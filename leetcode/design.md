# Design

+ [LRU Cache](#lru-cache)
+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)
+ [Binary Search Tree Iterator](#binary-search-tree-iterator)
+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)

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

## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues

```java
class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        while (queue1.size() != 0) {
            int curr = queue1.remove();
            queue2.add(curr);
        }
        queue1.add(x);
        while (queue2.size() != 0) {
            int curr = queue2.remove();
            queue1.add(curr);
        }
    }
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.remove();
    }
    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
```

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

```java
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.s1 = s1;
        this.s2 = s2;
    }
    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (s1.size() != 0) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (s2.size() != 0) {
            s1.push(s2.pop());
        }
    }
    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return s1.pop();
    }
    /**
     * Get the front element.
     */
    public int peek() {
        return s1.peek();
    }
    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}
```

## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/

```java
class BSTIterator {
    ArrayList<Integer> queue;
    int index;
    public BSTIterator(TreeNode root) {
        this.index = -1; //указатель на наименьший элемент
        this.queue = new ArrayList<Integer>();
        this.inorder(root); //заполняем стэк
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        this.inorder(root.left);
        this.queue.add(root.val);
        this.inorder(root.right);
    }
    public int next() {
        this.index += 1;
        return this.queue.get(this.index);
    }
    public boolean hasNext() {
        return this.index != this.queue.size() - 1;
    }
}
```

## Flatten Nested List Iterator

https://leetcode.com/problems/flatten-nested-list-iterator/

```java
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = queue;
        addToList(nestedList);
    }
    private void addToList(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0 || nestedList == null)
            return;
        for (NestedInteger a : nestedList) {
            if (a.isInteger())
                queue.add(a.getInteger());//определяет целочисленное значение
            else
                addToList(a.getList());//recursion
        }
    }
    @Override
    public Integer next() {
        return queue.poll();
    }
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```
