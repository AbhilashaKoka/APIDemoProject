package org.example.Number;

public class FibonacciSeries1 {
    public static void main(String[] args) {
        int count = 10;
        System.out.println("Fibonnacci series up to " + count + "number:");
        for (int i = 0; i <= count; i++) {
            System.out.println(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
