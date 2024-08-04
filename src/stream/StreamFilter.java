package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFilter {

    public static void main (String arg[]) {

        List<String> names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");

        List<String> longnames = names.stream()
                .filter(str -> str.length() > 6 && str.length() < 8) //Multiple conditions
                .collect(toList());

        longnames.forEach(System.out::println);


        List<Integer> num2 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> squares = num2.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(squares);


        List<Integer> list = Arrays.asList(1, 2, 3, null, 4, null, 5);
        List<Integer> result = list.stream()
                .filter(n -> n!= null)
                .map(num -> num + 10) //here you will be having a different logic
                .collect(toList());
        result.forEach(System.out::println);

    }

}
