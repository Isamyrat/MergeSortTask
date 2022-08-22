package com.example.sort.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.example.sort.utils.Utils.LOGGER;
import static com.example.sort.utils.Utils.OUTPUT_FILENAME;

public class WriterToFile<T> {

    private final File file = new File(OUTPUT_FILENAME);

    public void writeToFile(final List<T> items) {
        checkItemIsNull(items);
        for (T t : items) {
            writeToFile(t);
        }
    }

    private void checkItemIsNull(final List<T> t) {
        if (t.isEmpty()) {
            LOGGER.warning("Items is null!");
        }
    }

    private void writeToFile(final T item) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(item + "\n");
            writer.flush();
        } catch (IOException e) {
            LOGGER.warning("Trouble with write to file!" + e.getMessage());
        }
    }
}
