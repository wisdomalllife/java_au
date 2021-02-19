# LRUCache

```java
import java.util.HashMap;
import java.util.Map;
//lru-linked-hash-map
public class LRUCache<T> {

    private static class Node<T> {
        T key;
        T val;
        Node next;
        Node prev;
        Node(T key, T val) { this.key = key; this.val = val; }
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

    private Map<T, Node> cache = new HashMap<>();
    private int size;
    private DoublyLinkedList list = new DoublyLinkedList();

    public LRUCache(int capacity) {
        size = capacity;
    }

    public T get(T key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
// remove and push, так как нам важен порядок: в начале самые недавно используемые числа!
            list.remove(node);
            list.push(node);

            return ((T) node.val);
        }
        return null;
    }

    public void put(T key, T value) {
        if (cache.containsKey(key)) {
            list.remove(cache.get(key));
        }else if (cache.size() >= size) {
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

# Enums

```java
public class Colors {
    public static void main(String[] args) {

        ColorsOfPoints[] types = ColorsOfPoints.values();
        for (ColorsOfPoints s : types) { System.out.println(s); }
    }
}


enum ColorsOfPoints {
    Black,
    Grey,
    White;
} 
```

# Class like enum

```java
public class Colors {
    private String title;

    private Colors(String title) {
        this.title = title;
    }

    public static Colors Black = new Colors("Черный");
    public static Colors Grey = new Colors("Серый");
    public static Colors White = new Colors("Белый");

    @Override
    public String toString() {
        return "Colors{" +
                "title='" + title + '\'' +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        Colors black = Colors.Black;
        System.out.println(black);
    }
}
```

# Searching in complex numbers

```java
public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
} 


import java.util.List;

public class Searching {

    public static boolean isThereNumber(ComplexNumber complex, List<ComplexNumber> complexList) {
        return complexList.stream().anyMatch(p -> p.equals(complex));
    }

    public static long complexCount(ComplexNumber complex, List<ComplexNumber> complexList) {
        return complexList.stream().filter(p -> p.equals(complex)).count();
    }

} 
```
# Triangle

```java

```
