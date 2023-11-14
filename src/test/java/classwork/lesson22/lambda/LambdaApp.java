package classwork.lesson22.lambda;

public class LambdaApp {
    public static void main(String[] args) {
        Operationable operation = (a, b) -> a + b;

        int result = operation.calculate(20, 10);
        System.out.println(result);

        Operationable operation1 = (m, l) -> m/l;
        Operationable operation2 = (x, y) -> x-y;
        Operationable operation3 = (x, y) -> x * y;

        System.out.println(operation1.calculate(20, 10));
        System.out.println(operation2.calculate(20, 10));
        System.out.println(operation3.calculate(20, 10));
    }
}

@FunctionalInterface
interface Operationable{
    int calculate(int z, int k);
}
