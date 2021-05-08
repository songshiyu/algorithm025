package linkedlist;//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//        示例：
//        给定一个链表: 1->2->3->4->5, 和 k = 2.
//        返回链表 4->5.

import java.util.LinkedList;

/**
 * @description: 链表中倒数第k个节点
 * @create: 2021/5/8 08:44:22
 **/
public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用栈解题
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        LinkedList<ListNode> stack = new LinkedList<>();
        stack.add(head);

        ListNode node = head.next;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }

        return stack.get(stack.size() - k);
    }

    /**
     * 使用快慢指针解题
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter.next;
    }
}
