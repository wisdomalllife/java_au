import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    public Iterator<T> iterator() {
        return new MyIterator<>(this);
    }

    public class MyIterator<E> implements Iterator<E> {

        int index = 0;
        MyLinkedList<E> oMyLinkedList;

        public MyIterator(MyLinkedList<E> oMyLinkedList) {
            this.oMyLinkedList = oMyLinkedList;
        }
        
        public boolean hasNext() {
            return oMyLinkedList.lenOfList >= index + 1;
        }

        public E next() throws NoSuchElementException {
            return oMyLinkedList.get(index++);
        }

    }

    // MyLinkedList.Node node;
    private static class Node<T> {
        T val;
        Node next;
        Node(T val) { this.val = val; }
        Node(T val, Node next) { this.val = val; this.next = next; }
    }

    int lenOfList;
    private Node head, tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        lenOfList = 0;
        head = tail = null;
    }

    public Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public T get(int index) {
        if (index < 0 || lenOfList <= index) {
            return null;
        }
        return (T) getNode(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(T val) {
        Node newHead = new Node(val, head);
        if (lenOfList == 0) {
            head = tail = newHead;
        }
        else head = newHead;
        lenOfList++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(T val) {
        Node newTail = new Node(val);
        if (lenOfList == 0) {
            head = tail = newTail;
        }
        else {
            tail.next = newTail;
            tail = newTail;
        }
        lenOfList++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, T val) {
        if (index < 0 || lenOfList < index) return;
        if (index == 0) addAtHead(val);
        else if (lenOfList == index) addAtTail(val);
        else{
            Node curr = getNode(index - 1);
            Node node = new Node(val, curr.next);
            curr.next = node;
            lenOfList++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || lenOfList <= index) return;
        if (lenOfList == 1) head = tail = null;
        else if (index == 0) head = head.next;
        else {
            Node node = getNode(index - 1);
            node.next = node.next.next;
            if (lenOfList - 1 == index) tail = node;
        }
        lenOfList--;
    }
}
