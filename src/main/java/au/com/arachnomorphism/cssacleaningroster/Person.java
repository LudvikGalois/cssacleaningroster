package au.com.arachnomorphism.cssacleaningroster;

import java.util.Set;

public class Person extends DomainItem {

    private String name;
    private Set<String> skills;
    private Set<Day> goodDays;
    private Set<Day> badDays;
    private Set<Day> impossibleDays;
    private int daysAlreadyWorked;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<Day> getGoodDays() {
        return goodDays;
    }

    public void setGoodDays(Set<Day> goodDays) {
        this.goodDays = goodDays;
    }

    public Set<Day> getBadDays() {
        return badDays;
    }

    public void setBadDays(Set<Day> badDays) {
        this.badDays = badDays;
    }

    public Set<Day> getImpossibleDays() {
        return impossibleDays;
    }

    public void setImpossibleDays(Set<Day> impossibleDays) {
        this.impossibleDays = impossibleDays;
    }

    public int getDaysAlreadyWorked() {
        return daysAlreadyWorked;
    }

    public void setDaysAlreadyWorked(int daysAlreadyWorked) {
        this.daysAlreadyWorked = daysAlreadyWorked;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
