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
        return person;
    }

    public static Task createTask(String name, List<String> requirements) {
        Task task = new Task();
        task.setId(nextID());
        task.setName(name);
        task.setRequirements(requirements);
        return task;
    }

}
