package linkedlist;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//        示例:
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//
//        限制：
//        0 <= 节点个数 <= 5000

/**
 * @description: 反转链表
 * @create: 2021/5/8 10:55:55
 **/
public class Offer24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }
        return cur;
    }

    /**
     * 使用递归翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        return reverse(cur, head);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (pre == null) {
            return cur;
        }
        ListNode next = pre.next;
        pre.next = cur;
        cur = pre;
        pre = next;
        return reverse(cur, pre);
    }
}
