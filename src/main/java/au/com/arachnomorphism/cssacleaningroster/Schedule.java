package au.com.arachnomorphism.cssacleaningroster;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Schedule {

    private List<ScheduleItem> tasks;
    private List<Person> people;

    @PlanningScore
    private HardSoftScore score;

    public Schedule() {}

    @PlanningEntityCollectionProperty
    public List<ScheduleItem> getTasks() {
        return tasks;
    }

    public void setTasks(List<ScheduleItem> tasks) {
        this.tasks = tasks;
    }

    @ValueRangeProvider(id = "knownPeople")
    @ProblemFactCollectionProperty
    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
