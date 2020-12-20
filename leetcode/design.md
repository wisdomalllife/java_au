# Design

+ [Implement Stack using Queues](#implement-stack-using-queues)

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