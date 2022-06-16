package org.luoke.sort;

import java.util.Comparator;

/**
 * @author luoke
 * @date 2022/6/16 8:35
 */
public class CountSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] values, Comparator<Integer> comparator) {
        int max = values[0];
        int min = values[0];
        for (Integer value : values) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        int[] countArr = new int[max-min+1];
        for (Integer value : values) {
            countArr[value-min] ++;
        }
        int k = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                values[k++] = i+min;
                countArr[i]--;
            }
        }
    }
}
