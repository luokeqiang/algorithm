package org.luoke.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author luoke
 * @date 2022/6/16 9:16
 */
public class BucketSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] values, Comparator<Integer> comparator) {
        int bucketSize = Math.min(values.length, 5);
        ArrayList<Integer>[] bucketArr = new ArrayList[bucketSize * 2+2];
        for (int i = 0; i < bucketArr.length; i++) {
            bucketArr[i] = new ArrayList<>();
        }
        int max = Math.abs(values[0]);
        for (Integer value : values) {
            max = Math.max(Math.abs(max), Math.abs(value));
        }
        int gap = max/ bucketSize + 1;
        for (Integer value : values) {
            int index =  value / gap + bucketSize;
            bucketArr[index].add(value);
        }

        for (ArrayList<Integer> arrayList : bucketArr) {
            Collections.sort(arrayList);
        }
        int k = 0;
        for (ArrayList<Integer> arrayList : bucketArr) {
            for (int i = 0; i < arrayList.size(); i++) {
                values[k++] =  arrayList.get(i);
            }
        }
    }
}
