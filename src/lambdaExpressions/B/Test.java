package lambdaExpressions.B;

public class Test {
    // any argument order will be fine
    static boolean check(int b, TestInterface ti, String  c) {
        return ti.test(b);
    }
}
