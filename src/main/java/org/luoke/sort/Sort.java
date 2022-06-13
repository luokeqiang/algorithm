package org.luoke.sort;

import java.util.Comparator;

/**
 * 排序接口
 *
 * @author luoke
 * @date 2022/6/13 21:43
 */
public interface Sort<T> {
    void sort(T[] values, Comparator<T> comparator);

    /**
     *  交换数组元素
     * @param values 数组元素
     * @param i 索引位置1
     * @param j 索引位置2
     */
    default void swap(T[] values, int i, int j) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
