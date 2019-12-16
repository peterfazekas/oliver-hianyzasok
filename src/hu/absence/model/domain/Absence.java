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

    public AbsenceDate getAbsenceDate() {
        return absenceDate;
    }

    public String getName() {
        return name;
    }

    public List<AbsenceType> getAbsenceTypes() {
        return absenceTypes;
    }

    public long countAbsences(AbsenceType absenceType) {
        return absenceTypes.stream()
                .filter(i -> i.equals(absenceType))
                .count();
    }

    public long countTotalAbsences(AbsenceType absenceType) {
        return countAbsences(AbsenceType.X) + countAbsences(AbsenceType.I);
    }

}
