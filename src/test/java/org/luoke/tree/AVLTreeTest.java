package org.luoke.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author luoke
 * @date 2022/5/27 15:23
 */
class AVLTreeTest {
    AVLTree root;

    @BeforeEach
    void init() {
        root = new AVLTree(5);
    }

    @Test
    void find() {
        final AVLTree valueNode = root.find(root, 5);
        assertNotNull(valueNode);
        assertEquals(5, valueNode.getData());
    }

    @Test
    void insert() {
        assertEquals(5,root.insert(root, 10).getData());
        assertEquals(5,root.insert(root, 2).getData());
        assertEquals(5,root.insert(root, 3).getData());
        assertEquals(5,root.insert(root, 15).getData());
        assertEquals(5,root.insert(root, 20).getData());
        assertEquals(20,root.findMax(root).getData());
        assertEquals(2,root.findMin(root).getData());
    }

    @Test
    void findMax() {
        root.findMax(root);
    }
}