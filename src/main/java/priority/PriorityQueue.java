package priority;

import java.util.Arrays;

public class PriorityQueue<T> {
    private PriorityItem<T>[] heap;
    private int size;
    private final int INITIAL_CAPACITY = 11;

    public PriorityQueue() {
        heap = new PriorityItem[INITIAL_CAPACITY];
        size = 0;
    }

    private void resize() {
        int newCapacity = heap.length << 1; // length * 2
        heap = Arrays.copyOf(heap, newCapacity);
    }

    public int length() {
        return size;
    }

    public void add(T element, int priority) {
        PriorityItem<T> item = new PriorityItem<>(element, priority);
        if (size >= heap.length) {
            resize();
        }
        siftUp(size, item, this.heap);
        size++;
    }

    private static <T> void siftUp(int start, T item, Object[] heap) {
        Comparable<? super T> key = (Comparable<? super T>) item;
        while (start > 0) {
            int parent = (start - 1) >>> 1; //unsigned
            Object e = heap[parent];
            if (key.compareTo((T) e) <= 0)
                break;
            heap[start] = e;
            start = parent;
        }
        heap[start] = key;
    }

    public T remove() {
        T result = null;
        if (size > 0) {
            result = heap[0].getItem();
            final int n;
            final T last = (T) this.heap[(n = --size)];
            this.heap[n] = null;
            if(n > 0){
                siftDown(0, last, this.heap, n);
            }
        }
        return result;
    }

    private static <T> void siftDown(int start, T item, Object[] heap, int end) {
        Comparable<? super T> key = (Comparable<? super T>) item;
        int half = end >>> 1; // elements are non-leaf if index is more than half
        while (start < half) {
            int childIndex = (start << 1) + 1;
            Object child = heap[childIndex];
            int right = childIndex + 1;
            if (right < end && // check non-leaf for the last element on the heap
                    ((Comparable<? super T>) child).compareTo((T) heap[right]) < 0)
                child = heap[childIndex = right];
            if (key.compareTo((T) child) >= 0)
                break;
            heap[start] = child;
            start = childIndex;
        }
        heap[start] = key;
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue<String>();
        q.add("all", 42);
        q.add("world", 84);
        q.add("Hello", 99);
        q.add("it!", 2);
        q.add("and", 83);
        q.add("inhabit", 14);
        q.add("who", 16);

        while (q.length() > 0) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
