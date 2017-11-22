package au.com.arachnomorphism.cssacleaningroster;

import java.util.HashMap;

public class PreviousSchedule {

    private HashMap<Day,HashMap<String,String>> model;

    public PreviousSchedule() {}

    public HashMap<Day, HashMap<String, String>> getModel() {
        return model;
    }

    public void setModel(HashMap<Day, HashMap<String, String>> model) {
        this.model = model;
    }

    // Currently unused due to being unable to work how to call this in drools
    public boolean matchesOldSchedule(Day day, String jobName, String personName) {
        if (model == null) return false;
        if (model.containsKey(day)) {
            HashMap allocation = model.get(day);
            if (allocation.containsKey(jobName)) {
                return personName.equals(allocation.get(jobName));
            }
        }
        return false;
    }

}
