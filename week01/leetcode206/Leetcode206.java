//反转一个单链表。
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//        进阶:
//        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？


/**
 * @author songshiyu 翻转列表
 * @date 2021/3/31 20:02
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
     * 迭代方式
     *
     * @param
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode preNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode tmpNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tmpNode;
        }
        return preNode;
    }

    /**
     * 递归方式解决,需要在熟悉
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();

    }
}
