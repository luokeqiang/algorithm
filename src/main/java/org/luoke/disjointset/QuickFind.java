package org.luoke.disjointset;

/**
 * 颜色标记法
 *
 * @author luoke
 * @date 2022/6/7 16:03
 */
public class QuickFind {
    private final int[] color;
    private int n;

    public QuickFind(int n) {
        color = new int[n];
        for (int i = 0; i < color.length; i++) {
            color[i] = i;
        }
    }

    public int find(int x) {
        return color[x];
    }

    public void merge(int x, int y) {
        final int colorX = find(x);
        final int colorY = find(y);
        if (colorX == colorY) {
            return;
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == colorY) {
                color[i] = colorX;
            }
        }
    }
}
