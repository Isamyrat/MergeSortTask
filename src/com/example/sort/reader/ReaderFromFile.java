package com.example.sort.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static com.example.sort.utils.Utils.INTEGER_ITEMS_LIST;
import static com.example.sort.utils.Utils.LOGGER;
import static com.example.sort.utils.Utils.STRING_ITEMS_LIST;

public class ReaderFromFile {
    public void pickAllItems(final File file, final boolean isString) {
        try (Scanner scanner = new Scanner(file)) {
            hasNextItemInFile(scanner, file);
            while (scanner.hasNext()) {
                Pattern p = Pattern.compile("([a-zA-Z]+)");
                if (isString) {
                    if (scanner.hasNext(p)) {
                        STRING_ITEMS_LIST.add(scanner.nextLine());
                    } else {
                        scanner.nextLine();
                    }
                } else {
                    if (scanner.hasNextInt()) {
                        INTEGER_ITEMS_LIST.add(scanner.nextInt());
                    } else {
                        scanner.nextLine();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.warning("file not founded!!" + e.getMessage());
        }
    }

    private void hasNextItemInFile(final Scanner scanner, final File file) {
        if (!scanner.hasNext()) {
            LOGGER.warning(file.getName() + " file is empty!!");
        }
    }
}
