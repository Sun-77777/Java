public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(2);
        myLinkedList.display();
        myLinkedList.removeAllKey(2);
        System.out.println();
        myLinkedList.display();

    }
}
