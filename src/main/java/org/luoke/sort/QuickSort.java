package org.luoke.sort;

import java.util.Comparator;

/**
 *  快速排序
 * @author luoke
 * @date 2022/6/14 12:14
 */
public class QuickSort<T> implements Sort<T> {
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        sort(values, comparator, 0, values.length - 1);
    }

    private void sort(T[] values, Comparator<T> comparator, int start, int end) {
        if (start < end) {
            int pivot = getPivot(values, comparator, start, end);
            sort(values, comparator, start, pivot - 1);
            sort(values, comparator, pivot + 1, end);
        }
    }

    private int getPivot(T[] values, Comparator<T> comparator, int start, int end) {
        T pivotValue = values[start];
        while (start < end) {
            while (start < end && comparator.compare(pivotValue, values[end]) <= 0) {
                end--;
            }
            values[start] = values[end];
            while (start < end && comparator.compare(pivotValue, values[start]) >= 0) {
                start++;
            }
            values[end] = values[start];
        }
        values[start] = pivotValue;
        return start;
    }
}
