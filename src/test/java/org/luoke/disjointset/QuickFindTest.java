package org.luoke.disjointset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke
 * @date 2022/6/7 16:12
 */
class QuickFindTest {

    QuickFind quickFind;

    @BeforeEach
    void init() {
        quickFind = new QuickFind(5);

    }

    @Test
    void find() {
    }

    @Test
    void merge() {
        quickFind.merge(1, 4);
        assertEquals(quickFind.find(1),quickFind.find(4));
        quickFind.merge(0, 3);
        assertEquals(quickFind.find(0),quickFind.find(3));
        quickFind.merge(0, 1);
        assertEquals(quickFind.find(0),quickFind.find(4));
        assertNotEquals(quickFind.find(0),quickFind.find(2));
    }
}