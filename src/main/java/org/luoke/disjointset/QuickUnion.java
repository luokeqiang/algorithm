package org.luoke.disjointset;

/**
 * @author luoke
 * @date 2022/6/7 16:21
 */
public class QuickUnion {
    private final int[] data;
    public QuickUnion(int capacity){
        data = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

    public int find(int x) {
        int root = x;
        while (root != data[root]) {
            root = data[root];
        }
        while (root != x) {
            x = data[x];
            data[x] = root;
        }
        return root;
    }

    public void merge(int x, int y) {
        data[find(x)] = find(y);
    }

}
