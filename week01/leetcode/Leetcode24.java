//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

//        示例 1：
//        输入：head = [1,2,3,4]
//        输出：[2,1,4,3]

//        示例 2：
//        输入：head = []
//        输出：[]

//        示例 3：
//        输入：head = [1]
//        输出：[1]
//
//        提示：
//        链表中节点的数目在范围 [0, 100] 内
//        0 <= Node.val <= 100


/**
 * @author songshiyu 两两交换链表中的节点
 * @create: 2021/4/1 10:06:25
 **/
public class Leetcode24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 迭代模式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
