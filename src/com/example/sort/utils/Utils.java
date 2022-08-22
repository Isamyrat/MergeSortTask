package com.example.sort.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Utils {
    public static final Logger LOGGER = Logger.getLogger(Utils.class.getName());
    public static String OUTPUT_FILENAME;
    public static boolean isDescSorting = false;
    public static boolean isStringSorting = false;
    public static List<Integer> INTEGER_ITEMS_LIST = new ArrayList<>();
    public static List<String> STRING_ITEMS_LIST = new ArrayList<>();
    public static final String STRING_ARGUMENT = "-s";
    public static final String INTEGER_ARGUMENT = "-i";
    public static final String ASCENDING = "-a";
    public static final String DESCENDING = "-d";
}
