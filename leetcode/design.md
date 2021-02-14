# Design

1. https://leetcode.com/problems/flatten-nested-list-iterator/
4. https://leetcode.com/problems/implement-stack-using-queues/
5. https://leetcode.com/problems/implement-queue-using-stacks/
6. https://leetcode.com/problems/binary-search-tree-iterator/

+ [LRU Cache](#lru-cache)
+ [Min Stack](#min-stack)

## LRU Cache

https://leetcode.com/problems/lru-cache/

```java
class LRUCache {
    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoublyLinkedList {
        Node head, tail;
        public void push(Node node) {
            node.next = head;
            node.prev = null;
            if (head == null) tail = node;
            else head.prev = node;
            head = node;
        }
        public void remove(Node node) {
            if (node == head) head = node.next;
            if (node == tail) tail = node.prev;
            if (node.next != null) node.next.prev = node.prev;
            if (node.prev != null) node.prev.next = node.next;
        }
    }
    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private DoublyLinkedList list = new DoublyLinkedList();
    public LRUCache(int capacity) {
        size = capacity;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
// remove and push, так как нам важен порядок: в начале самые недавно используемые числа!
            list.remove(node);
            list.push(node);
            return node.val;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            list.remove(cache.get(key));
        } else if (cache.size() >= size) {
            Node end = list.tail;
            list.remove(end);
            cache.remove(end.key);
        }
        Node node = new Node(key, value);
        list.push(node);
        cache.put(key, node);
    }
}
```

## Min Stack

https://leetcode.com/problems/min-stack/

```java
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minsStack;
    public MinStack() {
        stack = new Stack<>();
        minsStack = new Stack<>();//for getMin()
    }
    public void push(int x) {
        if (minsStack.isEmpty() || minsStack.peek() >= x) minsStack.push(x);
        stack.push(x);
    }
    // stack.peek() берет вершину стэка
    public void pop() {
        if (stack.peek().equals(minsStack.peek())) minsStack.pop();
        stack.pop();
    }
    // ничего не рушится тк top of minsStack - the smallest!
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minsStack.peek();
    }
}
```
