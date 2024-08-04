package lambdaExpressions.A;

public class TestLambdaMain {


     static void me(){
        System.out.println("lllllllll");
    };

    public static void main(String aras[]){


        TestLambda testLambda = (a , b) ->{
            System.out.println("aaaaaa");
            me();
            int y= a+b;
            return y - 8 ;
        };

        int s= testLambda.concatString(5, 10);
        System.out.println(s);

    }
}
