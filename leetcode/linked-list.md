# Linked List

+ [Sort List](#sort-list)

## Sort List

https://leetcode.com/problems/sort-list/

```java
// сортировка слиянием сверху вниз
public ListNode middleNode(ListNode head) {// середина
    ListNode prev = null;
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    if (prev != null) prev.next = null;  //разорвать предыдущее соединение
    return slow;
}
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {// соединение
    ListNode head = new ListNode(0);
    ListNode curr = head;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    if (l1 == null) curr.next = l2;
    if (l2 == null) curr.next = l1;
    return head.next;
}
// рекурсия
// делим список(каждый раз пополам) на подсписки размером 1
// отсортируйте каждый подсписок и объедините его в один отсортированный список(mergeTwoLists).
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode middle = middleNode(head);
    ListNode left = sortList(head);
    ListNode right = sortList(middle);
    return mergeTwoLists(left, right);
}
```
