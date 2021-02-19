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
