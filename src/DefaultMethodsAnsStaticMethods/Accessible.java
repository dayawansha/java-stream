package DefaultMethodsAnsStaticMethods;

interface Accessible{
    default void access(){
        System.out.println("access");
    }

    default void print(){
        System.out.println("Clickable");
    }


}