package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {
    private final Comparator<T> comparator;
    private final List<T> heap = new ArrayList<>();
    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T pop() {
        if (heap.isEmpty()) {
        throw new NoSuchElementException("Cannot pop from an empty heap.");
        }
        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    public T peek() {
        if (heap.isEmpty()) {
        throw new NoSuchElementException("Cannot peek into an empty heap.");
        }
        return heap.get(0);
    }

    public void push(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public int count() {
        return heap.size();
    }

    private void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && comparator.compare(heap.get(i), heap.get(parent)) < 0) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }
    private void heapifyDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heap.size() && comparator.compare(heap.get(left), heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && comparator.compare(heap.get(right), heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}