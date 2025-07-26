public class MyHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MyHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public void add(int val) {
        if (size == capacity)
            throw new IllegalStateException("Heap is full");
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    public int poll() {
        if (size == 0)
            throw new IllegalStateException("Heap is empty");

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] < heap[parent]) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) smallest = left;
            if (right < size && heap[right] < heap[smallest]) smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private boolean isLeaf(int index) {
        return index >= size / 2 && index < size;
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap(10);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);

        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");  // Output: 1 3 5 8
        }
    }
}