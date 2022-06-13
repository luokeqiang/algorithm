package org.luoke.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author luoke
 * @date 2022/6/13 21:56
 */
class SortTest {
    Comparator<Integer> comparator;
    Sort<Integer> sort;

    Integer[] values = new Integer[] {61, 97, 0, 17, 53, 34, 22, 31, 36, 49 ,22};
    Integer[] expectValues = new Integer[] {0, 17, 22, 22, 31, 34, 36, 49, 53, 61, 97};
    @BeforeEach
    void init() {
        comparator = (v1,v2) -> v1 - v2;
    }
    @AfterEach
    void after() {
        Integer[] calculateValues = Arrays.copyOf(values, values.length);
        sort.sort(calculateValues, comparator);
        assertArrayEquals(expectValues, calculateValues);
    }
    @Test
    void sort() {
        sort = new SelectSort<>();
    }

    @Test
    void bubbleSort() {
        sort = new BubbleSort<>();
    }

    @Test
    void InsertSort() {
        sort = new InsertSort<>();
    }

    @Test
    void shellSort() {
        sort = new ShellSort<>();
    }
}