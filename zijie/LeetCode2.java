/**
 * @description: 两数相加
 * @create: 2021/5/11 17:25:39
 **/
public class LeetCode2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int tmp = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null ? 0 : l1.val);
            int l2Val = (l2 == null ? 0 : l2.val);

            int sum = l1Val + l2Val + tmp;

            //此处不能写反，否则计算结果是错误的
            tmp = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (tmp == 1) {
            cur.next = new ListNode(tmp);
        }
        return pre.next;
    }
}
