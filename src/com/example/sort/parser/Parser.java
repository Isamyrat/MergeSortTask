package com.example.sort.parser;

import com.example.sort.reader.ReaderFromFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.sort.utils.Utils.ASCENDING;
import static com.example.sort.utils.Utils.DESCENDING;
import static com.example.sort.utils.Utils.INTEGER_ARGUMENT;
import static com.example.sort.utils.Utils.LOGGER;
import static com.example.sort.utils.Utils.OUTPUT_FILENAME;
import static com.example.sort.utils.Utils.STRING_ARGUMENT;
import static com.example.sort.utils.Utils.isDescSorting;
import static com.example.sort.utils.Utils.isStringSorting;

public class Parser {
    private int argsCounter = 0;

    public void parse(final String[] args) {
        if (args.length >= 3) {
            takeArgumentsOfSorting(args);
            OUTPUT_FILENAME = args[argsCounter++];
            takeInputFileNames(args);
        } else {
            LOGGER.warning("Console parameters is wrong!");
            throw new NullPointerException("Console parameter is not enough");
        }
    }

    private void takeArgumentsOfSorting(final String[] args) {
        for (int i = 0; i < 2; i++) {
            if (ASCENDING.equalsIgnoreCase(args[argsCounter]) ||
                DESCENDING.equalsIgnoreCase(args[argsCounter])) {
                if (DESCENDING.equalsIgnoreCase(args[argsCounter])) {
                    isDescSorting = true;
                }
                argsCounter++;
            }

            if (STRING_ARGUMENT.equalsIgnoreCase(args[argsCounter]) ||
                INTEGER_ARGUMENT.equalsIgnoreCase(args[argsCounter])) {
                if (STRING_ARGUMENT.equalsIgnoreCase(args[argsCounter])) {
                    isStringSorting = true;
                }
                argsCounter++;
            }
        }
    }

    private void takeInputFileNames(final String[] args) {
        List<String> inputFileNames = new ArrayList<>(Arrays.asList(args).subList(argsCounter, args.length));
        ReaderFromFile reader = new ReaderFromFile();
        if (inputFileNames.size() < 1) {
            LOGGER.warning("Please write input fileNames!!");
        } else {
            for (String fileName : inputFileNames) {
                reader.pickAllItems(new File(fileName), isStringSorting);
            }
        }
    }
}
