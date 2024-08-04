package lambdaExpressions.B;

public class LambdaExpressionPassMethodTest {
    public static void main(String arg[]) {
        // lambda expression
        boolean result = Test.check(10,(x) -> (x%2) == 0, "ss");
        System.out.println("The result is: "+ result);
    }
}
