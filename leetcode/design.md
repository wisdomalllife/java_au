# Design

+ [Min Stack](#min-stack)

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