//设计实现双端队列。
//        你的实现需要支持以下操作：
//
//        MyCircularDeque(k)：构造函数,双端队列的大小为k。
//        insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
//        insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
//        deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
//        deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
//        getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
//        getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
//        isEmpty()：检查双端队列是否为空。
//        isFull()：检查双端队列是否满了。
//
//        MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//        circularDeque.insertLast(1);			        // 返回 true
//        circularDeque.insertLast(2);			        // 返回 true
//        circularDeque.insertFront(3);			        // 返回 true
//        circularDeque.insertFront(4);			        // 已经满了，返回 false
//        circularDeque.getRear();  				// 返回 2
//        circularDeque.isFull();				        // 返回 true
//        circularDeque.deleteLast();			        // 返回 true
//        circularDeque.insertFront(4);			        // 返回 true
//        circularDeque.getFront();				// 返回 4
//         
//        提示：
//
//        所有值的范围为 [1, 1000]
//        操作次数的范围为 [1, 1000]
//        请不要使用内置的双端队列库。

/**
 * @description: 设计循环双端队列 TODO 需要修改
 * @E-mail: ssy3@meitu.com
 * @create: 2021/4/6 12:06:37
 **/
public class MyCircularDeque {

    private int[] array = null;
    private int size;
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        array = new int[k];
        size = 0;
        head = tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (head == tail && size != 0) {
            return false;
        }
        head = (head - 1 + array.length) % array.length;
        array[head] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (head == tail && size != 0) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1 + array.length) % array.length;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = (head + 1 + array.length) % array.length;
        size--;
        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = (tail - 1 + array.length) % array.length;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return array[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return array[tail - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail && size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return head == tail && size != 0;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertFront(2);
    }
}
