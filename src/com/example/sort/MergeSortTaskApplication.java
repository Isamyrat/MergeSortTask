package com.example.sort;

import com.example.sort.parser.Parser;
import com.example.sort.service.Sorter;

import static com.example.sort.utils.Utils.LOGGER;
import static com.example.sort.utils.Utils.isStringSorting;

public class MergeSortTaskApplication {

    public static void main(String[] args) {
        new Parser().parse(args);

        Sorter sorter = new Sorter();
        sorter.sort(isStringSorting);

        String header = "=== Completed ===";
        LOGGER.info(header);

    }
}
