package org.luoke.sort;

import java.util.Comparator;

/**
 * 希尔排序
 *
 * @author luoke
 * @date 2022/6/13 22:54
 */
public class ShellSort<T> implements Sort<T> {
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        for (int step = values.length / 2; step > 0; step /= 2) {
            for (int i = step; i < values.length; i++) {
                int j = i;
                T target = values[i];
                while (j - step >= 0 && comparator.compare(target, values[j - step]) < 0) {
                    values[j] = values[j - step];
                    j-=step;
                }
                if (j != i) {
                    values[j] = target;
                }
            }
        }
    }
}
