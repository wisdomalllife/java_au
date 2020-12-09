# Linked List

+ [Middle of the Linked List](#middle-of-the-linked-list)

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```