# Design

+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)

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