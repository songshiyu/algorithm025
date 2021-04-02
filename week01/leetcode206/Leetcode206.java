//反转一个单链表。
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//        进阶:
//        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

import java.util.Stack;

/**
 * @author songshiyu  反转链表
 * @create: 2021/3/31 14:54:31
 **/
public class Leetcode206 {

    public static class ListNode {
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
     * 迭代的方式实现翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode tmp = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = tmp;

        }
        return pre;
    }



}
