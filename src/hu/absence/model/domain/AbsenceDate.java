package hu.absence.model.domain;

public class AbsenceDate {

    private final int month;
    private final int day;

    public AbsenceDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public String getNameOfDay() {
        return getNameOfDay(month, day);
    }

    public boolean isDay(String nameOfDay) {
        return getNameOfDay().equals(nameOfDay);
    }

    public static String getNameOfDay(int month, int day) {
        return hetnapja(month, day);
    }

    private static String hetnapja(int honap, int nap) {
        String[] napnev = {"vasarnap", "hetfo", "kedd", "szerda", "csutortok", "pentek", "szombat"};
        int[] napszam = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 335};
        int napsorszam = (napszam[honap - 1] + nap) % 7;
        return napnev[napsorszam];
    }
}
