package hu.absence.model.domain;

public class AbsenceDate {

    private final int month;
    private final int day;
    private final String nameOfDay;

    public AbsenceDate(int month, int day) {
        this.month = month;
        this.day = day;
        this.nameOfDay = "";
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public boolean isDay(String nameOfDay) {
        return this.nameOfDay.equals(nameOfDay);
    }
}
