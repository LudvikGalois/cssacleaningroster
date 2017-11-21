package au.com.arachnomorphism.cssacleaningroster;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class ScheduleItem extends DomainItem {

    private Task job;
    private Person rostered;
    private Day day;

    public ScheduleItem() {}

    public Task getJob() {
        return job;
    }

    public void setJob(Task job) {
        this.job = job;
    }

    @PlanningVariable(valueRangeProviderRefs = {"knownPeople"})
    public Person getRostered() {
        return rostered;
    }

    public void setRostered(Person rostered) {
        this.rostered = rostered;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public boolean isValidAllocation() {
        if (rostered == null) return false;
        return job.canBeDoneBy(rostered);
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "job=" + job +
                ", rostered=" + rostered +
                ", day=" + day +
                '}';
    }
}
