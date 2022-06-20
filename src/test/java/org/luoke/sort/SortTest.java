package org.luoke.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author luoke
 * @date 2022/6/13 21:56
 */
class SortTest {
    Comparator<Integer> comparator;
    Sort<Integer> sort;

    Integer[][] tests = new Integer[][]{
            {5,2,3,1},
            {1,2,3,5},
            {4,1,5,8,7,9},
            {1,4,5,7,8,9},
            {61, 97, 0, 17, 53, 34, 22, 31, 36, 49 ,22},
            {0, 17, 22, 22, 31, 34, 36, 49, 53, 61, 97},
            {2,1},
            {1,2},
            {2,1,3},
            {1,2,3},
            {2,1,3,4},
            {1,2,3,4},
            {4,3,2,1},
            {1,2,3,4},
            {-4,3,2,1},
            {-4,1,2,3},
            {-4,3,2,-999},
            {-999,-4,2,3},
            {-4,3,2,-999,9999},
            {-999,-4,2,3,9999},
    };

    @BeforeEach
    void init() {
        comparator = (v1,v2) -> v1 - v2;
    }

    @AfterEach
    void after() {
        for (int i = 0; i < tests.length; i+=2) {
            final Integer[] test = tests[i];
            Integer[] calculateValues = Arrays.copyOf(test, test.length);
            sort.sort(calculateValues, comparator);
            assertArrayEquals(tests[i+1],calculateValues);
        }
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

    @Test
    void mergeSort() {
        sort = new MergeSort<>();
    }

    @Test
    void quickSort() {
        sort = new QuickSort<>();
    }

    @Test
    void countSort() {
        sort = new CountSort();
    }

    @Test
    void bucketSort() {
        sort = new BucketSort();
    }

    @Test
    void heapSort() {
        sort = new HeapSort<>();
    }
}