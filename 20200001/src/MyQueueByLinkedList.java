public class MyQueueByLinkedList {
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode head = null;
    private ListNode tail;

    //链表尾插
    public void offer(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    //头删
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    //取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        return ret;
    }
}
