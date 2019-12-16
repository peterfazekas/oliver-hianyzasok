package hu.absence.model.service;

import hu.absence.model.domain.Absence;
import hu.absence.model.domain.AbsenceDate;
import hu.absence.model.domain.AbsenceType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<Absence> parse(List<String> lines) {
        AbsenceDate absenceDate = null;
        List<Absence> absences = new ArrayList<>();
        for (var line : lines) {
            if (isDate(line)) {
                absenceDate = createAbsenceDate(line);
            } else {
                absences.add(createAbsence(absenceDate, line));
            }
        }
        return absences;
    }

    private boolean isDate(String line) {
        return line.charAt(0) == '#';
    }

    private AbsenceDate createAbsenceDate(String line) {
        String[] items = line.split(" ");
        return new AbsenceDate(Integer.parseInt(items[1]), Integer.parseInt(items[2]));
    }

    private Absence createAbsence(AbsenceDate absenceDate, String line) {
        String[] items = line.split(" ");
        String name = items[0] + " " + items[1];
        return new Absence(absenceDate, name, createAbsenceTypes(items[2]));
    }

    private List<AbsenceType> createAbsenceTypes(String types) {
        return types.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(AbsenceType::valueOf)
                .collect(Collectors.toList());
    }

}
