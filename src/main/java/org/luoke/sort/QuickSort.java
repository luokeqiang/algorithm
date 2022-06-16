package org.luoke.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  快速排序
 * @author luoke
 * @date 2022/6/14 12:14
 */
public class QuickSort<T> implements Sort<T> {
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
//        sort(values, comparator, 0, values.length - 1);
        sortWithThree(values, comparator, 0, values.length - 1);
//        sortWithThree2(values, comparator, 0, values.length - 1);
    }

    private void sort(T[] values, Comparator<T> comparator, int start, int end) {
        while (start < end) {
            int pivot = getPivot(values, comparator, start, end);
//            sort(values, comparator, start, pivot - 1);
            sort(values, comparator, pivot + 1, end);
            end = pivot - 1;
        }
    }

    private int getPivot(T[] values, Comparator<T> comparator, int start, int end) {
        T pivotValue = values[start];
        while (start < end) {
            while (start < end && comparator.compare(pivotValue, values[end]) <= 0) {
                end--;
            }
            if (start < end) {
                values[start++] = values[end];
            }
            while (start < end && comparator.compare(pivotValue, values[start]) >= 0) {
                start++;
            }
            if (start < end) {
                values[end--] = values[start];
            }
        }
        values[start] = pivotValue;
        return start;
    }

    private void sortWithThree(T[] values, Comparator<T> comparator, int start, int end) {
        while (start < end) {
            T pivotValue = values[start];
            int lt = start+1;
            int i = start+1;
            int gt = end;
            while (i <= gt) {
                final int compare = comparator.compare(pivotValue,values[i]);
                if (compare > 0) {
                    swap(values, i++, lt++);
                } else if (compare == 0) {
                    i++;
                } else {
                    swap(values, i, gt--);
                }
            }
            swap(values, start, lt - 1);

            sort(values, comparator, gt+1, end);
            end = lt-2;
        }
    }
}
