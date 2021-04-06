//给定一个链表，判断链表中是否有环。
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
//如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//如果链表中存在环，则返回 true 。 否则，返回 false 。

import java.util.*;

/**
 * @author songshiyu 判断链表中是否有环
 * @create: 2021/4/2 14:31:11
 **/
public class Leetcode141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用hash表，7 ms
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        int pos = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head.next;
        while (cur != null) {
            cur = cur.next;
            if (!map.containsKey(cur)) {
                map.put(cur, pos++);
            } else {
                pos = -1;
                break;
            }
        }
        return pos == -1 ? true : false;
    }

    /**
     * 使用Set集合 6ms
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 官方题解：快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next.next;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }
}
