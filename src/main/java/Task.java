import java.util.List;

public class Task extends DomainItem {

    private String name;
    private List<String> requirements;

    public Task() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public boolean canBeDoneBy(Person person) {
        for (String requirement : requirements) {
            if (!person.getSkills().contains(requirement)) return false;
        }
        return true;
    }

}
