package cs5004list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CS5004SortedLinkedListTest {

    @Test
    public void testInsertLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        assertEquals("1", list.toString().trim());
    }

    @Test
    public void testInsertLinkedListReverseInsert() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        assertEquals("1 2 3 4 5", list.toString().trim());
    }



    @Test
    public void testInsertBeforeLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(3);
        list.insert(1);
        assertEquals("1 3", list.toString().trim());

    }

    @Test
    public void testInsertAfterLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        list.insert(3);
        assertEquals("1 3", list.toString().trim());

    }

    @Test
    public void testInsertDuplicateLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        assertEquals("1 2 2 3", list.toString().trim());

    }

    @Test
    public void testInsertBetweenLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        list.insert(3);
        list.insert(2);
        assertEquals("1 2 3", list.toString().trim());

    }

    @Test
    public void testInsertManyLinkedList() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        list.insert(3);
        list.insert(2);
        list.insert(12);
        list.insert(13);
        list.insert(3);
        list.insert(13);
        list.insert(1);
        assertEquals("1 1 2 3 3 12 13 13", list.toString().trim());

    }

    @Test
    public void testCount() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        list.insert(1);
        list.insert(3);
        list.insert(2);
        list.insert(12);
        list.insert(13);
        list.insert(3);
        list.insert(13);
        list.insert(1);
        assertEquals(8, ((CS5004SortedLinkedList)list).size());

    }

    @Test
    public void testCountEmpty() {
        CS5004SortedList<Integer> list = new CS5004SortedLinkedList<>();
        assertEquals(0, ((CS5004SortedLinkedList)list).size());

    }

}