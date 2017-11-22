(ns au.com.arachnomorphism.cssacleaningroster.simple-schedule
  (:import (java.util ArrayList HashSet)
           (au.com.arachnomorphism.cssacleaningroster DomainFactory)
           (java.time LocalDate))
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:gen-class))

(defn csv-data->maps
  "Zip the first row of the csv with each row of the rest, making a map
  with the keys being the elements of the first row"
  [csv-data]
    (map zipmap
      (->> csv-data ;; First row is the header
           first
           repeat)
      (rest csv-data)))

(defn map->person
  "Given a map, return a Person domain object"
  [person-map]
  (let [skills (HashSet.)]
    (dorun (map #(when (= (second %) "1") (.add skills (first %)))
                (dissoc person-map "name")))
    (DomainFactory/createPerson (person-map "name") skills)))

(defn row->task
  "Convert a csv row to a task"
  [row]
  (DomainFactory/createTask (first row) (->> row rest ArrayList.)))

(defn read-people
  "Turn a csv file of people into an array list"
  [fname]
  (with-open [file (io/reader fname)]
    (->> file
         csv/read-csv
         csv-data->maps
         (map map->person)
         ArrayList.)))

(defn read-task
  "Turn a CSV of tasks into a map from task name to task object"
  [fname]
  (with-open [file (io/reader fname)]
    (->> file
         csv/read-csv
         rest
         (map row->task)
         (map #(vector (. % getName) %))
         (into {})
         doall)))

(defn read-schedule-item
  "Convert a csv row to an array list of schedule item"
  [known-tasks fname]
  (with-open [file (io/reader fname)]
    (->> file
         csv/read-csv
         rest
         (map #(let [[time name] %]
                 (DomainFactory/createScheduleItem
                   (DomainFactory/createDay (LocalDate/parse time))
                   (known-tasks name))))
         ArrayList.)))

(defn -main
  [& args]
  (println (read-people "/home/probie/test.csv"))
  (println (read-schedule-item (read-task "/home/probie/test2.csv") "/home/probie/test3.csv")))

