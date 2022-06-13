package org.luoke.sort;

import java.util.Comparator;

/**
 * 冒泡排序
 *
 * @author luoke
 * @date 2022/6/13 22:09
 */
public class BubbleSort<T> implements Sort<T> {

    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (comparator.compare(values[i], values[j]) > 0) {
                    swap(values, i, j);
                }
            }
        }
    }
}
