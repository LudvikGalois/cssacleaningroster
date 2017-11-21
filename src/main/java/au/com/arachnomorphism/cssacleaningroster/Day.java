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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day day = (Day) o;

        return date != null ? date.equals(day.date) : day.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }
}
