package org.luoke.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

/**
 *  基数排序
 * @author luoke
 * @date 2022/6/20 8:50
 */
public class RadixSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] values, Comparator<Integer> comparator) {
        if (values.length == 0) {
            return;
        }
        int max = Math.abs(values[0]);
        // 记录数组中是否有负数
        boolean hasNegative = false;
        for (Integer value : values) {
            if (value < 0) {
                hasNegative = true;
            }
            max = Math.max(Math.abs(value), Math.abs(max));
        }
        ArrayList<Integer>[] buckets = new ArrayList[hasNegative ? 20 : 10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }
        int addIndex = hasNegative ? 10 : 0;
        for (int exp = 1; max > 0; max /= 10,exp *= 10) {
            for (Integer value : values) {
                int index = (value / exp) % 10 + addIndex;
                buckets[index].add(value);
            }
            for (int i = 0,k = 0; i < buckets.length; i++) {
                if (buckets[i].size() > 1) {
                    Collections.sort(buckets[i]);
                }
                while (!buckets[i].isEmpty()) {
                    values[k++] = buckets[i].remove(0);
                }
            }
        }
    }
}
