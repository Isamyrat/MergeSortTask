package com.example.sort.service;

import com.example.sort.writer.WriterToFile;

import java.util.Collections;
import java.util.List;

import static com.example.sort.utils.Utils.INTEGER_ITEMS_LIST;
import static com.example.sort.utils.Utils.STRING_ITEMS_LIST;
import static com.example.sort.utils.Utils.isDescSorting;

public class Sorter {
    public void sort(final boolean isStringSorting) {
        if (isStringSorting) {
            sortingString();
        } else {
            sortingInteger();
        }
    }

    private void sortingString(){
        WriterToFile<String> writer = new WriterToFile<>();
        MergeSort<String> integerMergeSort = new MergeSort<>();
        List<String> stringList = integerMergeSort.mergeSort(STRING_ITEMS_LIST);
        if (isDescSorting) {
            reverseList(stringList);
        }
        writer.writeToFile(stringList);
    }
    private void sortingInteger(){
        WriterToFile<Integer> writer = new WriterToFile<>();
        MergeSort<Integer> integerMergeSort = new MergeSort<>();
        List<Integer> integerList = integerMergeSort.mergeSort(INTEGER_ITEMS_LIST);
        if (isDescSorting) {
            reverseList(integerList);
        }
        writer.writeToFile(integerList);
    }

    private <T> List<T> reverseList(List<T> list) {
        Collections.reverse(list);
        return list;
    }
}
