package linkedlist;

import java.util.Stack;

/**
 * @description: 二进制链表转整数
 * @create: 2021/5/8 08:18:26
 **/
public class LeetCode1290 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        stack.add(head.val);

        ListNode node = head.next;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        int res = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Integer pop = stack.pop();
            res += (pop == 0 ? 0 : Math.pow(2, i));
        }
        return res;
    }
}
