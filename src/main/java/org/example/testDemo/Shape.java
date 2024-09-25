package org.example.testDemo;

public class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}
 class Circle extends Shape{
    public void display()
    {
        System.out.println("display-derived");
    }
//     protected void display()
//     {
//         System.out.println("display-derived");
//     }
//     private void display()
//     {
//         System.out.println("display-derived");
//     }

     public static void main(String[] args) {
         Shape s=new Circle();
         s.display();
     }

}
