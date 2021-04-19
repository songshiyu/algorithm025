//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//        示例 1：
//        输入：head = [1,3,2]
//        输出：[2,3,1]

import java.util.LinkedList;

/**
 * @author songshiyu  剑指 Offer 06. 从尾到头打印链表
 * @create: 2021/4/16 15:38:44
 **/
public class LeetCode06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 元素加入双端队列后。在遍历双端队列
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> queue = new LinkedList<>();
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        while (preNode.next != null) {
            queue.addFirst(preNode.next.val);
            preNode = preNode.next;
        }
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.pop();
        }
        return result;
    }

    /**
     * 网友的牛逼解法，最后不需要再次遍历
     *
     * @param head
     * @return
     */

    private int[] finalResult;
    private int i = 0, j = 0;

    public int[] reversePrint2(ListNode head) {
        solve(head);
        return finalResult;
    }

    private void solve(ListNode node) {
        if (node == null) {
            finalResult = new int[i];
            return;
        }
        i++;
        solve(node.next);
        finalResult[j] = node.val;
        j++;
    }

}
