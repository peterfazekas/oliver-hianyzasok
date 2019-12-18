package hu.absence.controller;

import hu.absence.model.domain.Absence;
import hu.absence.model.domain.AbsenceDate;
import hu.absence.model.domain.AbsenceType;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbsenceService {

    private static final String SEPARATOR = " ";

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
        return AbsenceDate.getNameOfDay(month, day);
    }

    public long countCertainAbsences(String nameOfDay, int lessonId) {
        return absences.stream()
                .filter(i -> i.isAbsence(nameOfDay, lessonId))
                .count();
    }

    public String getSlackerStudentNames() {
        Map<String, Long> studentAbsenceCountMap = createStudentAbsenceCountMap();
        Long maxAbsenceCount = studentAbsenceCountMap.values().stream()
                .max(Comparator.naturalOrder())
                .get();
        return studentAbsenceCountMap.entrySet().stream()
                .filter(i -> i.getValue() == maxAbsenceCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(SEPARATOR));
    }

    private Map<String, Long> createStudentAbsenceCountMap() {
        return absences.stream()
                .collect(Collectors.groupingBy(Absence::getName, Collectors.summingLong(Absence::countTotalAbsences)));
    }
}
