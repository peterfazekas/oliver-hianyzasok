package hu.absence.controller;

import hu.absence.model.domain.Absence;
import hu.absence.model.domain.AbsenceDate;
import hu.absence.model.domain.AbsenceType;

import java.util.List;

public class AbsenceService {

    private final List<Absence> absences;

    public AbsenceService(List<Absence> absences) {
        this.absences = absences;
    }

    public int getAbsencesCount() {
        return absences.size();
    }

    public long countTotalAbsenceType(AbsenceType absenceType) {
        return absences.stream()
                .mapToLong(i -> i.countAbsences(absenceType))
                .sum();
    }

    public String getNameOfDay(int month, int day) {
        AbsenceDate absenceDate = new AbsenceDate(month, day);
        return absenceDate.getNameOfDay();
    }
}
