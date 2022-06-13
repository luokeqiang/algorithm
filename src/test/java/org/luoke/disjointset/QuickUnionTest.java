//package org.luoke.disjointset;
//
//import org.junit.jupiter.api.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author luoke
// * @date 2022/6/7 16:28
// */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class QuickUnionTest {
//    static QuickUnion quickUnion;
//    @BeforeAll
//    static void init() {
//        quickUnion = new QuickUnion(5);
//    }
//
//    @Test
//    @Order(2)
//    void find() {
//        assertEquals(2, quickUnion.find(2));
//        assertEquals(2, quickUnion.find(4));
//        assertEquals(2, quickUnion.findWithIterator(2));
//        assertEquals(2, quickUnion.findWithIterator(4));
//        assertEquals(4, quickUnion.getSize(2));
//        assertEquals(2, quickUnion.getSize(1));
//    }
//
//    @Test
//    @Order(1)
//    void merge() {
//        quickUnion.merge(2, 4);
//        quickUnion.merge(1,3);
//        quickUnion.merge(2,1);
//    }
//
//    @Test
//    void test(){
//
//    }
//}