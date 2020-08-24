public class Tttttt {
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode curNext = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    //删除所有值是val的结点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                while(cur != null && cur.val == val) {
                    cur = cur.next;
                }
            }
            tmp.next = cur;
            tmp = tmp.next;
            if (cur != null) {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
