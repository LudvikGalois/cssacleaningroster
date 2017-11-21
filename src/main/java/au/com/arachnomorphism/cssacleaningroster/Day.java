package au.com.arachnomorphism.cssacleaningroster;

import java.time.LocalDate;

public class Day extends DomainItem {

    private LocalDate date;

    public Day() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "date=" + date +
                ", dayOfWeek=" + date.getDayOfWeek() +
                '}';
    }
}
