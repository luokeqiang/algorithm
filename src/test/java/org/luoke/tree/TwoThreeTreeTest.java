package org.luoke.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke
 * @date 2022/6/2 15:37
 */
class TwoThreeTreeTest {

    TwoThreeTree root;
    @BeforeEach
    void init() {
        root = new TwoThreeTree();
        root.data[0] = 5;
        root.data[1] = 10;


//        final TwoThreeTree t2 = new TwoThreeTree();
//        final TwoThreeTree t3 = new TwoThreeTree();
//        root.children[1] = t2;
//        root.children[2] = t3;
    }

    @Test
    void find() {
        assertNull(root.find(root,3));
        assertNull(root.find(root,8));
        assertEquals(root, root.find(root, 5));
        assertEquals(root, root.find(root, 10));

        final TwoThreeTree t1 = new TwoThreeTree();
        t1.data[0] = 2;
        root.children[0] = t1;

        final TwoThreeTree t2 = new TwoThreeTree();
        t2.data[0] = 6;
        root.children[1] = t2;

        final TwoThreeTree t3 = new TwoThreeTree();
        t3.data[0] = 15;
        root.children[2] = t3;

        assertEquals(t1,root.find(root,2));
        assertEquals(t2,root.find(root,6));
        assertEquals(t3,root.find(root,15));
    }

    @Test
    void getNextNode() {
    }
}