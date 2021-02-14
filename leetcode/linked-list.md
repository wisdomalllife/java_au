# Linked List
1. https://leetcode.com/problems/reverse-linked-list/
4. https://leetcode.com/problems/merge-two-sorted-lists/
5. https://leetcode.com/problems/intersection-of-two-linked-lists/
6. https://leetcode.com/problems/sort-list/ тут Merge Sort

+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Reorder List](#reorder-list)

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

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

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

```java
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
```

## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/

```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = growAroundCenter(s, i, i);
        int len2 = growAroundCenter(s, i, i + 1);//для палиндрома из четного кол. элементов
        int len = Math.max(len1, len2);
        if (len > end - start + 1) { // i - центр нового подпалиндрома
            start = i - (len - 1) / 2;// len-1 для четного случая
            end = i + len / 2;//
        }
    }
    return s.substring(start, end + 1); // вывод  подстроки, substring берет до end не включительно -> +1
}
private int growAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;// смотрим сколько одинаковых пар по бокам и определяем длину подпалиндрома (r=a+1, l=b-1, r-l-1=a-b+1+1-1=a-b+1=len)
}
```
