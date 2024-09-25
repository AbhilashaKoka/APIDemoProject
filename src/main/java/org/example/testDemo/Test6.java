package org.example.testDemo;

public class Test6 {
    public static void main(String[] args) {
        Base0 obj=new Base1();
        ((Base2) obj).test();
    }
}

class Base0{

    public void test(){

    }
}
class Base1 extends Base0{
    public void test(){
        System.out.println("Base1");
   }
    }

class Base2 extends Base0{
    public void test(){
        System.out.println("Base2");
    }
}
