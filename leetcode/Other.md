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
