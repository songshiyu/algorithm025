package linkedlist;

/**
 * @description: 删除链表中的节点
 * @create: 2021/5/8 08:15:16
 **/
public class LeetCode237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
