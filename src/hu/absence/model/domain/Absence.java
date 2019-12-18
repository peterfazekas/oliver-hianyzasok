package hu.absence.model.domain;

import java.util.List;

public class Absence {

    private final AbsenceDate absenceDate;
    private final String name;
    private final List<AbsenceType> absenceTypes;

    public Absence(AbsenceDate absenceDate, String name, List<AbsenceType> absenceTypes) {
        this.absenceDate = absenceDate;
        this.name = name;
        this.absenceTypes = absenceTypes;
    }

    public String getName() {
        return name;
    }

    public long countAbsences(AbsenceType absenceType) {
        return absenceTypes.stream()
                .filter(i -> i.equals(absenceType))
                .count();
    }

    public long countTotalAbsences() {
        return countAbsences(AbsenceType.X) + countAbsences(AbsenceType.I);
    }

    public boolean isAbsence(String nameOfDay, int lessonId) {
        return absenceDate.isDay(nameOfDay) &&
                (absenceTypes.get(lessonId) == AbsenceType.I || absenceTypes.get(lessonId) == AbsenceType.X);
    }

}
