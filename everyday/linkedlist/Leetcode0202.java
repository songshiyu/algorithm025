package linkedlist;

/**
 * @description: 面试题 02.02. 返回倒数第 k 个节点
 * @create: 2021/5/8 10:22:40
 **/
public class Leetcode0202 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }

        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter.val;
    }
}
