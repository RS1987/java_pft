package my.lux.brand.sandbox;

public class HelloBigWorld {

    public static void main(String[] args) {
        hello("Alex");

        double len = 5;
        double a = 9;
        double b = 3;

        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!!!!");
    }

    public static double area(double l) {
        return l * l;
    }

    public static double area(double a, double b) {
        return a * b;
    }
}