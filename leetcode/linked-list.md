# Linked List

+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)

## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode head1 = headA;
    ListNode head2 = headB;
    while (head1 != head2) {
        head1 = head1 == null ? headB : head1.next;
        head2 = head2 == null ? headA : head2.next;
    }
    return head1;
}
```