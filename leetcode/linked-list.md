# Linked List

+ [Reverse Linked List](#reverse-linked-list)

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextel = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextel;
        }
        return prev;
    }
}
```