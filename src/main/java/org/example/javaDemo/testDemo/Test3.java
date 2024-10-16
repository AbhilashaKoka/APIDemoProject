package org.example.javaDemo.testDemo;


 class Base {

    public Base() {
        System.out.println("Base");
    }
}

 class Derived extends Base {
    public Derived() {
        super();
        System.out.println("derived");
    }
}
 class DeriDerived extends Derived {
    public DeriDerived() {
        super();
        System.out.println("DeriDerived");
    }
}
public class Test3 {
    public static void main(String[] args) {
        Derived b=new DeriDerived();
    }

}
