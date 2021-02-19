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

# Colors like enum

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

```
