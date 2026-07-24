interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    protected double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Triangle implements Shape {
    public double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {

        Circle c = new Circle(5.0);
        Rectangle r = new Rectangle(4.0, 6.0);
        Triangle t = new Triangle(3.0, 8.0);

        System.out.println("----- Shape Area Calculator -----\n");

        System.out.println("Circle:");
        System.out.println("Radius = 5.0");
        System.out.println("Area of Circle = " + c.calculateArea());

        System.out.println();

        System.out.println("Rectangle:");
        System.out.println("Length = 4.0, Width = 6.0");
        System.out.println("Area of Rectangle = " + r.calculateArea());

        System.out.println();

        System.out.println("Triangle:");
        System.out.println("Base = 3.0, Height = 8.0");
        System.out.println("Area of Triangle = " + t.calculateArea());
    }
}