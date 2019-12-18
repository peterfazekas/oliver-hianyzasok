package hu.absence;

import hu.absence.controller.AbsenceService;
import hu.absence.model.domain.AbsenceType;
import hu.absence.model.service.Console;
import hu.absence.model.service.DataApi;
import hu.absence.model.service.DataParser;
import hu.absence.model.service.FileReader;

import java.util.Scanner;

public class App {

    private final AbsenceService absenceService;
    private final Console console;

    App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        absenceService = new AbsenceService(dataApi.getData("naplo.txt"));
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: A naplóban " + absenceService.getAbsencesCount() + " bejegyzés van.");
        System.out.println("3. feladat: Az igazolt hiányzások száma " + absenceService.countTotalAbsenceType(AbsenceType.X)
                + ", az igazolatlanoké " + absenceService.countTotalAbsenceType(AbsenceType.I) + " óra.");
        System.out.println("5. feladat");
        System.out.print("A hónap sorszáma = ");
        int month = console.readInt();
        System.out.print("A nap sorszáma = ");
        int day = console.readInt();
        System.out.println("Azon a napon "+ absenceService.getNameOfDay(month, day) + " volt.");
        System.out.println("6. feladat");
        System.out.print("A nap neve = ");
        String nameOfDay = console.read();
        System.out.print("Az óra sorszáma = ");
        int lessonId = console.readInt();
        System.out.println("Ekkor összesen "+ absenceService.countCertainAbsences(nameOfDay, lessonId - 1)
                + " óra hiányzás történt.");
        System.out.println("7. feladat: A legtöbbet hiányzó tanulók: " + absenceService.getSlackerStudentNames());
    }
}
