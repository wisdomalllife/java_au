# Linked List


+ [Palindrome Linked List](#palindrome-linked-list)

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

```java
class Solution {
    boolean res = true;
    ListNode helper(ListNode root, ListNode node) {
        if (root == null) return node;
        ListNode start = helper(root.next, node); //рекурсивно доходим ко конца, root=end
        if (root.val != start.val) res = false;
        return start.next; // двигаем start, root двигается обратно автоматически
    }
    public boolean isPalindrome(ListNode head) {
        helper(head, head);
        return res;
    }
}
```