package org.luoke.sort;

import java.util.Comparator;

/**
 * @author luoke
 * @date 2022/6/13 22:32
 */
public class InsertSort<T> implements Sort<T> {
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        for (int i = 1; i < values.length; i++) {
            int j = i;
            T target = values[j];
            while (j > 0 && comparator.compare(target, values[j - 1]) < 0) {
                values[j] = values[j - 1];
                j --;
            }
            if (j != i) {
                values[j] = target;
            }
        }
    }
}
