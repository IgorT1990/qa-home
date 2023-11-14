package homework.lambda_generic;

public class Task3 {
    @FunctionalInterface
    interface Discriminant{
        double calculate (double a, double b, double c);
    }

    public static void main(String[] args) {
        Discriminant calculateDiscriminant = (a, b, c) -> b * b - 4 * a * c;
        double a = 1.0;
        double b = 3.0;
        double c = 5.0;

        double discriminant = calculateDiscriminant.calculate(a, b, c);
        System.out.println(discriminant);

    }
}
