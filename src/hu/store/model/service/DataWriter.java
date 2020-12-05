package hu.store.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataWriter {

    private final String filename;

    public DataWriter(String filename) {
        this.filename = filename;
    }

    public void printAll(List<String> lines) {
        try {
            Files.write(Path.of(filename), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
