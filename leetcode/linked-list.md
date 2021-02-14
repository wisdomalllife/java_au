# Linked List
5. https://leetcode.com/problems/intersection-of-two-linked-lists/

+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Reorder List](#reorder-list)
+ [Sort List](#sort-list)
+ [Reverse Linked List](#reverse-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)

## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // проблема в указателе на первый элемент нового листа, его необходимо создать
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
    return head.next;  // нулевой узел не нужен
}
```

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

```java
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
```

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
