package linkedlist;

//给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//  如果有两个中间结点，则返回第二个中间结点。
//
//        示例 1：
//        输入：[1,2,3,4,5]
//        输出：此列表中的结点 3 (序列化形式：[3,4,5])
//        返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//        注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//        ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
//
//        示例 2：
//        输入：[1,2,3,4,5,6]
//        输出：此列表中的结点 4 (序列化形式：[4,5,6])
//        由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//        提示：
//        给定链表的结点数介于 1 和 100 之间。

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 链表的中间结点
 * @create: 2021/5/8 14:07:23
 **/
public class LeetCode876 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * hash表解题
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode pre = head;
        int index = 0;
        while (pre != null) {
            map.put(index++, pre);
            pre = pre.next;
        }
        return map.get(index / 2);
    }

    /**
     * 快慢指针：
     * 一个指针每次只走一步，一个指针每次走两步，因此当快指针走到尾部时，慢指针正好处于链表的中间节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode front = head, latter = head;
        while (front != null && front.next != null) {
            latter = latter.next;
            front = front.next.next;
        }
        return latter;
    }

}
