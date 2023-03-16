package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeapTest {

        @Test
        void testConstructorZeroComparator() {
            Comparator<Integer> comparator = (a, b) -> 0;
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator);
            assertNotNull(heap);
        }

        @Test
        void testConstructorPositiveNegativeComparator() {
            Comparator<Integer> comparator = (a, b) -> a - b;
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator);
            assertNotNull(heap);
        }

        @Test
        void testPopEmptyHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            assertThrows(NoSuchElementException.class, () -> heap.pop());
        }

        @Test
        void testPopSingleElementHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(1);
            assertEquals(1, heap.pop());
        }

        @Test
        void testPopMultipleElementsHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(3);
            heap.push(1);
            heap.push(5);
            assertEquals(1, heap.pop());
            assertEquals(3, heap.pop());
            assertEquals(5, heap.pop());
        }

        @Test
        void testPeekEmptyHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testPeekSingleElementHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(1);
            assertEquals(1, heap.peek());
        }

        @Test
        void testPeekMultipleElementsHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(3);
            heap.push(1);
            heap.push(5);
            assertEquals(1, heap.peek());
        }

        @Test
        void testPushSingleElement() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(1);
            assertEquals(1, heap.peek());
        }

        @Test
        void testPushMultipleElements() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(3);
            heap.push(1);
            heap.push(5);
            assertEquals(1, heap.peek());
        }

        @Test
        void testCountEmptyHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            assertEquals(0, heap.count());
        }

        @Test
        void testCountSingleElementHeap() {
            BinaryHeap<Integer> heap = new BinaryHeap<Integer>((a, b) -> a - b);
            heap.push(1);
            assertEquals(1, heap.count());
        }
    @Test
    public void toCompleteCoverage() {
        BinaryHeap<Integer> heap = new BinaryHeap<>((a, b) -> a - b);
        heap.push(3);
        heap.push(2);
        heap.push(1);
        heap.push(4);
        heap.push(5);
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(4, heap.pop());
        assertEquals(5, heap.pop());
    }

}