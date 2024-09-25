package org.example.testDemo;

public class Test5 {
    private void foo(){
        System.out.println("In BaseClass.foo()");
    }

    void bar(){
        System.out.println("In BaseClass.bar()");
    }

    public static void main(String[] args) {
        Test5 po=new DerivedClass();
        po.foo();
        po.bar();
    }

}
class DerivedClass extends Test5{
    void foo(){
        System.out.println("In Derived.foo()");
    }

    void bar(){
        System.out.println("In Derived.bar()");
    }

}
