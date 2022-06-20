package org.luoke.sort;

import java.util.Comparator;

/**
 * @author luoke
 * @date 2022/6/17 15:42
 */
public class HeapSort<T> implements Sort<T>{
    @Override
    public void sort(T[] values, Comparator<T> comparator) {
        for (int len = values.length ;len > 0;len --) {
//            for (int j = len / 2 - 1; j >= 0; j--) {
//                heapSort(values,j,len,comparator);
//            }
            up(values,len / 2 - 1,len,comparator);

            swap(values, 0, len - 1);
        }
    }

    private void heapSort(T[] values, int lastIndex, int len,Comparator<T> comparator) {
        int leftIndex = 2 * lastIndex + 1;
        // 没有左子树
        if (leftIndex >= len) {
            return;
        }
        // 没有右子树
        int rightIndex = 2 * lastIndex + 2;
        if (rightIndex >= len) {
            if (comparator.compare(values[lastIndex], values[leftIndex]) < 0) {
                swap(values,lastIndex,leftIndex);
            }
        } else {
            int maxIndex = comparator.compare(values[leftIndex], values[rightIndex]) > 0 ? leftIndex : rightIndex;
            if (comparator.compare(values[maxIndex],values[lastIndex]) > 0) {
                swap(values, lastIndex, maxIndex);
                heapSort(values, maxIndex, len, comparator);
            }
        }
    }

    private void up(T[] values, int lastIndex, int len,Comparator<T> comparator) {
        while (lastIndex >= 0) {
            int leftIndex = 2 * lastIndex + 1;
            // 没有左子树
            if (leftIndex >= len) {
                return;
            }
            // 没有右子树
            int rightIndex = 2 * lastIndex + 2;
            if (rightIndex >= len) {
                if (comparator.compare(values[lastIndex], values[leftIndex]) < 0) {
                    swap(values,lastIndex,leftIndex);
                }
            } else {
                int maxIndex = comparator.compare(values[leftIndex], values[rightIndex]) > 0 ? leftIndex : rightIndex;
                if (comparator.compare(values[maxIndex],values[lastIndex]) > 0) {
                    swap(values, lastIndex, maxIndex);
                    down(values, maxIndex, len, comparator);
                }
            }
            if (lastIndex == 0) {
                break;
            }
            lastIndex = (lastIndex -1)/2;
        }
    }
    private void down(T[] values, int lastIndex, int len,Comparator<T> comparator) {
        while (lastIndex < len) {
            int leftIndex = 2 * lastIndex + 1;
            // 没有左子树
            if (leftIndex >= len) {
                return;
            }
            // 没有右子树
            int rightIndex = 2 * lastIndex + 2;
            if (rightIndex >= len) {
                if (comparator.compare(values[lastIndex], values[leftIndex]) < 0) {
                    swap(values,lastIndex,leftIndex);
                }
                return;
            }
            int maxIndex = comparator.compare(values[leftIndex], values[rightIndex]) > 0 ? leftIndex : rightIndex;
            if (comparator.compare(values[maxIndex],values[lastIndex]) > 0) {
                swap(values, lastIndex, maxIndex);
            }
            lastIndex = maxIndex;
        }
    }

}
