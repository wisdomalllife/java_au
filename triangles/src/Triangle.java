import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private final Points a;
    private final Points b;
    private final Points c;
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(Points a, Points b, Points c) {
        this.a = a;
        this.b = b;
        this.c = c;
        sideA = sideLength(a, b);
        sideB = sideLength(c, b);
        sideC = sideLength(a, c);
    }

    public boolean isTriangle(){
        return (((c.getY()-a.getY())/(b.getY()-a.getY())) != ((c.getX()-a.getX())/(b.getX()-a.getX())));
    }

    public static double sideLength(Points A, Points B){
        return Math.pow((A.getX()- B.getX())*(A.getX()- B.getX())+(A.getY()- B.getY())*(A.getY()- B.getY()), 0.5);
    }

    public boolean isIsoscelesTriangle(){
        return (sideA == sideB  || sideA == sideC ||sideB == sideC);
    }
    public double space(){
        double p = (sideA + sideB + sideC)/2;
        return Math.pow(p*(p-sideA)*(p - sideB )*(p-sideC), 0.5);
    }

    public static Triangle value(String coordinates) {
        String[] coords = coordinates.split(" ");
        if ( coords.length < 6 ) return null;
        List<Points> pointsList = new ArrayList<>();
        for (int i = 0; i < 6; i+=2) {
            pointsList.add(new Points(Double.parseDouble(coords[i]), Double.parseDouble(coords[i+1])));
        }
        Triangle triangle = new Triangle(pointsList.get(0), pointsList.get(1), pointsList.get(2));
        return  triangle.isTriangle() ? triangle : null;
    }

    @Override
    public String toString() {
        return a.getX() + " " + a.getY() +
                " " + b.getX() + " " + b.getY() +
                " " + c.getX() + " " + c.getY() ;
    }
}
