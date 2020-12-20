# Design

+ [Implement Queue using Stacks](#implement-queue-using-stacks)

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