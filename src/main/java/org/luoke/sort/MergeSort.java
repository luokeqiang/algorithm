package org.luoke.sort;

import java.util.Comparator;

/**
 *  归并排序
 * @author luoke
 * @date 2022/6/14 8:57
 */
public class MergeSort<T> implements Sort<T>{
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        sort(values, comparator, 0, values.length - 1, (T[]) new Object[values.length]);
    }

    private void sort(T[] values,Comparator<T> comparator,int start,int end,T[] temps) {
        if (start < end) {
            int mid = (start + end) >> 1;
            sort(values, comparator, start, mid, temps);
            sort(values, comparator, mid + 1, end, temps);
            merge(values, comparator, start, mid, end, temps);
        }
    }

    private void merge(T[] values, Comparator<T> comparator, int start, int mid, int end, T[] temps) {
        int k = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (comparator.compare(values[left], values[right]) < 0) {
                temps[k++] = values[left++];
            } else {
                temps[k++] = values[right++];
            }
        }

        while (left <= mid) {
            temps[k++] = values[left++];
        }

        while (right <= end) {
            temps[k++] = values[right++];
        }
        k = 0;
        while (start <= end) {
            values[start++] = temps[k++];
        }

    }
}
