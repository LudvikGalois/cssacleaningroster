(ns findPeople
  (:import (java.util HashSet))
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn take-csv
  "Takes file name and reads data."
   [fname]
   (with-open [file (io/reader fname)]
     (doall (csv/read-csv file))))

(defn csv-data->maps
  "Zip the first row of the csv with each row of the rest, making a map
  with the keys being the elements of the first row"
  [csv-data]
    (map zipmap
      (->> (first csv-data) ;; First row is the header
           (map keyword) ;; Drop if you want string keys instead
           repeat)
      (rest csv-data)))

(defn map->person
  "Given a map, return a Person domain object"
  [person-map]
  (let [skills (HashSet.)]
    (when (= (get person-map :exec) "1") (.add skills "Exec"))
    (when (= (get person-map :committee) "1") (.add skills "Committee"))
    (when (= (get person-map :cro) "1") (.add skills "CRO"))
    (DomainFactory/createPerson (get person-map :name) skills)))

(defn create-people
  "Generate a list of people from a csv"
  [fname]
  (->> fname take-csv csv-data->maps (map map->person)))

(println (create-people "/home/probie/test.csv"))