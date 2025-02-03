package DemoTest.testDemo;

import java.util.Arrays;

//Main method can be overloaded
public class DemoMethodOverloadingInMain {
    public static void main(String[] args) {
        System.out.println("String[] args main method called");
        main(new Double[]{1.0,2.0, 3.0});
    }




    public static void main(Double[] args) {
        System.out.println("Double[] args main method called");
        System.out.println(Arrays.toString(args));
    }
    }

