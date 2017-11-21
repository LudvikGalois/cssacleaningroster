package au.com.arachnomorphism.cssacleaningroster;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainFactory {

    private static int currentID = 0;

    private static int nextID() {
        int next = currentID;
        currentID++;
        return next;
    }

    public static Person createPerson(String name, Set<String> skills) {
        Person person = new Person();
        person.setId(nextID());
        person.setName(name);
        person.setSkills(skills);
        person.setGoodDays(new HashSet());
        person.setBadDays(new HashSet());
        person.setImpossibleDays(new HashSet());
        person.setDaysAlreadyWorked(0);
        return person;
    }

    public static Task createTask(String name, List<String> requirements) {
        Task task = new Task();
        task.setId(nextID());
        task.setName(name);
        task.setRequirements(requirements);
        return task;
    }

    public static Day createDay(LocalDate date) {
        Day day = new Day();
        day.setId(nextID());
        day.setDate(date);
        return day;
    }

    public static ScheduleItem createScheduleItem(Day day, Task task) {
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.setId(nextID());
        scheduleItem.setJob(task);
        scheduleItem.setDay(day);
        return scheduleItem;
    }

    public static ScheduleItem createdScheduledItem(Day day, Task task, Person person) {
        ScheduleItem scheduleItem = createScheduleItem(day, task);
        scheduleItem.setRostered(person);
        return scheduleItem;
    }

    public static Schedule createSchedule(List<Person> people, List<ScheduleItem> tasks) {
        Schedule schedule = new Schedule();
        schedule.setPeople(people);
        schedule.setTasks(tasks);
        return schedule;
    }

}
