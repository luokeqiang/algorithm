package org.luoke.tree;


/**
 * 2-3 树
 * @author luoke
 * @date 2022/6/2 10:02
 */
public class TwoThreeTree {
    // 存放数据
    public Integer[] data;
    // 子节点
    public TwoThreeTree[] children;

    public TwoThreeTree() {
        this.data = new Integer[3];
        this.children = new TwoThreeTree[5];
    }


    public TwoThreeTree find(TwoThreeTree root,Integer value) {
        if (root == null || value == null) {
            return null;
        }
        while (root != null) {
            final TwoThreeTree nextNode = getNextNode(root, value);
            if (nextNode == root) {
                break;
            }
            root = nextNode;
        }
        return root;
    }

    public TwoThreeTree getNextNode(TwoThreeTree root, Integer value) {
        if (root.data[0] != null) {
            if (root.data[0].equals(value)) {
                return root;
            }
            if (value < root.data[0]) {
                return root.children[0];
            }
        }
        if (root.data[1] != null) {
            if (root.data[1].equals(value)) {
                return root;
            }
            if (value > root.data[1]) {
                return root.children[2];
            }
        }
        return root.children[1];
    }
}
