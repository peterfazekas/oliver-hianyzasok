package hu.absence.model.service;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public String read() {
        return scanner.next();
    }
}
