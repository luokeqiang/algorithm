package org.luoke.sort;

import java.util.Comparator;

/**
 * 选择排序
 *
 * @author luoke
 * @date 2022/6/13 21:42
 */
public class SelectSort<T> implements Sort<T>{

    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        for (int i = 0; i < values.length - 1; i++) {
            int min  = i;
            for (int j = i + 1; j < values.length; j++) {
                if (comparator.compare(values[min], values[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                swap(values, min, i);
            }
        }
    }
}
