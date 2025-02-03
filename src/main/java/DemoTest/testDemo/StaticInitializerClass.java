package DemoTest.testDemo;

public class StaticInitializerClass {
    //    static
//    {
//        System.out.println("Static Initializer!!!");
//        System.exit(0);
//    }
//}
//It is working before Java 7 but, now this is not avaliable with newer version of Java
//We can make main method as final
    public static final void main(String[] args) {
        System.out.println("Hello World!!");
    }
}