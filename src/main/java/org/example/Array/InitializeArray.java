package org.example.Array;
public class InitializeArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Inline initialized array:");

        for (int number : numbers){
            System.out.println(number + "");
        }

        String[] names = new String[]{"java", "Python", "C++", "Javascript"};
        System.out.println("\n\n Initialized with anonymous array:");

        for (String name : names){
            System.out.print(name + " ");
        }
     double[] doubles;
    {
        doubles = new double[4];
        doubles[0] = 1.1;
        doubles[1] = 2.2;
        doubles[2] = 3.3;
        doubles[3] = 4.4;
    }

    System.out.println("\n\n Initialized in a block");
}
}
