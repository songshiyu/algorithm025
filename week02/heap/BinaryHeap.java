import java.util.Arrays;

/**
 * @author songshiyu binaryHeap  数组实现N叉大顶堆
 * @create: 2021/4/9 09:16:47
 **/
public class BinaryHeap {

    /**
     * 设定堆是几叉
     */
    public static final int d = 2;

    /**
     * 定义数组存储堆内元素
     */
    private int[] heap;

    /**
     * 堆内元素个数
     */
    private int heapSize;

    public BinaryHeap(int capacity) {
        this.heapSize = 0;
        heap = new int[capacity + 1];
        /**
         * 使用-1填充整个数组
         */
        Arrays.fill(heap, -1);
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    /**
     * 查找索引i位置元素的父节点
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) / d;
    }

    /**
     * 查找索引为i的父节点的，第k个子节点
     *
     * @param i
     * @param k
     * @return
     */
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /**
     * 向堆内插入元素,插入元素时，先将该元素放在堆的最后一个节点，然后将该节点进行上浮
     * 直到重新形成一个大顶堆\小顶堆
     *
     * @param val
     */
    public void insert(int val) {
        if (isFull()) {
            throw new RuntimeException("Heap is full,No space to insert new element");
        }
        heap[heapSize] = val;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    /**
     * 堆内元素上浮
     *
     * @param i
     */
    private void heapifyUp(int i) {
        int insertValue = heap[i];
        /**
         * 当索引大于0，并且要插入的值大于其父节点时，进行上浮
         */
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }

    /**
     * 删除堆内索引位置为i的元素：直接用堆内最后一个节点代替当前要删除节点，然后依次进行下沉
     *
     * @param i
     * @return
     */
    public int delete(int i) {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty,no elements to delete");
        }
        int deleteValue = heap[i];
        heap[i] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(i);
        return deleteValue;
    }

    /**
     * 将索引为i的元素进行下沉，找到其对应的位置
     *
     * @param i
     */
    private void heapifyDown(int i) {
        int targetValue = heap[i];
        while (kthChild(i, 1) < heapSize) {
            int maxChild = maxChild(i);
            if (targetValue >= heap[maxChild]) {
                break;
            }
            heap[i] = heap[maxChild];
            i = maxChild;
        }
        heap[i] = targetValue;
    }

    /**
     * 查找堆内索引位置i元素的最大子节点对应索引
     *
     * @param i
     * @return
     */
    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    /**
     * 打印堆
     */
    public void printHeap() {
        System.out.println("nHeap = ");
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 查找堆内的最大值
     *
     * @return
     */
    public int finMax() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty...");
        }
        return heap[0];
    }

    public static void main(String[] args) {
        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.printHeap();
        maxHeap.delete(5);
        maxHeap.printHeap();
        maxHeap.delete(2);
        maxHeap.printHeap();
    }
}
