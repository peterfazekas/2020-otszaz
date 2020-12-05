package hu.store.model.service;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }

    public int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
