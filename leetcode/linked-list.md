# Linked List

+ [Reorder List](#reorder-list)

## Reorder List

https://leetcode.com/problems/reorder-list/

```java
// Середина = slow будет в конце, разверни вторую половину
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextel = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextel;
    }
    return prev;
}

public ListNode reorderList(ListNode head) {
    if (head == null) return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode end = reverseList(slow);
    ListNode begin = head;
    while (begin.next != null && end.next != null) {
        ListNode nexT = begin.next;
        ListNode nexTT = end.next;
        begin.next = end;
        begin.next.next = nexT;
        begin = nexT;
        end = nexTT;
    }
    return head;
}
```