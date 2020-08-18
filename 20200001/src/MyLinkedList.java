
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    public ListNode head;

    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void addLast(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = this.head;
        if (cur == null) {
            this.head = node;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (key == cur.val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void addIndex(int index,int val) {
        if (index == 0) {
            addFirst(val);
        }

        if (index == this.size()) {
            addLast(val);
        }

        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
    }

    private ListNode searchIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index的位置不合理");
        }
        int n = index - 1;
        ListNode cur = this.head;
        while(n > 0) {
            cur = cur.next;
            n--;
        }
        return cur;
    }

    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.val == key) {
                prev.next = prev.next.next;
                return;
            } else {
                prev = prev.next;
            }
        }
    }
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }                  //2 2 2 3 4 2
        ListNode prev = this.head;
        ListNode cur = null;
        while (prev.next != null) {
            if (prev.next.val == key) {
                cur = prev.next;
                while (cur.next != null && cur.next.val == key) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            }
            prev = prev.next;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }
}
