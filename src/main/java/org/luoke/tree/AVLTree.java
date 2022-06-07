package org.luoke.tree;

import java.util.Objects;

/**
 * @author luoke
 * @date 2022/5/27 15:21
 */
public class AVLTree {
    private Integer data;
    private int height;
    private AVLTree left;
    private AVLTree right;

    public AVLTree(Integer data) {
        this.data = data;
        this.height = 1;
    }


    public AVLTree insert(AVLTree root,Integer data){
        if (root == null) {
            return new AVLTree(data);
        }
        if (Objects.equals(data, root.data)) {
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return AVLBalance(root);
    }

    public AVLTree AVLBalance(AVLTree root) {
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) > 0) {
                root = AVLTreeLL(root);
            } else {
                root = AVLTreeLR(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) > 0) {
                root = AVLTreeRL(root);
            } else {
                root = AVLTreeRR(root);
            }
        }
        calcHeight(root);
        return root;
    }

    public Integer getData() {
        return data;
    }

    public int getHeight(AVLTree node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void calcHeight(AVLTree node) {
        if (node == null) {
            return;
        }
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }

    public int getBalanceFactor(AVLTree node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public AVLTree AVLTreeLL(AVLTree node) {
        return rightRote(node);
    }

    public AVLTree AVLTreeLR(AVLTree root) {
        root.left = leftRote(root.left);
        return rightRote(root);
    }

    public AVLTree AVLTreeRL(AVLTree root) {
        root.right = rightRote(root.right);
        return rightRote(root);
    }

    public AVLTree AVLTreeRR(AVLTree node) {
        return leftRote(node);
    }

    public AVLTree find(AVLTree root, Integer data) {
        if (root == null || data == null) {
            return null;
        }
        if (data.equals(root.data)) {
            return root;
        }
        final AVLTree leftData = find(root.left, data);
        if (leftData != null) {
            return leftData;
        }
        return find(root.right, data);
    }

    public AVLTree findMax(AVLTree root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    public AVLTree findMin(AVLTree root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public AVLTree rightRote(AVLTree root) {
        AVLTree newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        calcHeight(root);
        calcHeight(newRoot);
        return newRoot;
    }

    public AVLTree leftRote(AVLTree root) {
        final AVLTree newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        calcHeight(root);
        calcHeight(newRoot);
        return newRoot;
    }

    @Override
    public String toString() {
        return "AVLTree{" +
                "data=" + data +
                ", height=" + height +
                '}';
    }
}

