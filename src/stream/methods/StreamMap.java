package stream.methods;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class StreamMap {
    public static void main(String[] args) {

        /**
         * 1. Simple Java example to convert a list of Strings to upper case.
         */
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int sum2 = integers.stream()
                .mapToInt(e -> e)
                .sum();

        int sum3 = integers.stream()
                .reduce(0, (a, b) -> a + b);

        int sum4 = integers.stream()
                .reduce(0, Integer::sum);

        /**
         * 1.1 Simple Java example to convert a list of Strings to upper case.
         */
        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        // Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(toList());
        System.out.println(collect); //[A, B, C, D]

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]

        /**
         *2.1 Get all the name values from a list of the staff objects.
         */
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Java 8
        List<String> collect2 = staff.stream().map(x -> x.getName()).collect(toList());
        System.out.println(collect2); //[mkyong, jack, lawrence]

        /**
         * 3.1 This example shows you how to convert a list of staff objects into a list of StaffPublic objects.
         */
        List<Staff> staff3 = Arrays.asList(
                new Staff("dushman", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        // convert inside the map() method directly.
        List<StaffPublic> result3 = staff3.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("dushman".equals(temp.getName())) {
                obj.setExtra("this field is for dushman only!");
            }
            return obj;
//        }).collect(Collectors.toList());
        }).peek(s -> System.out.println( " print method 1=" + " " +  s.getName() + " " + s.getAge()+ " " + s.getExtra()))
                .collect(toList());

        System.out.println(" print methode 2=");
        result3.forEach(s -> System.out.println(s.getName() + " " + s.getAge()+ " " + s.getExtra()));

        System.out.println(" print methode 3=");
        result3.forEach(System.out::println);
    }
}

class Staff {
    private String name;
    private int age;
    private BigDecimal salary;

    public Staff(String mkyong, int i, BigDecimal bigDecimal) {
        this.name = mkyong;
        this.age = i;
        this.salary = bigDecimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
class StaffPublic {

    private String name;
    private int age;
    private String extra;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}

