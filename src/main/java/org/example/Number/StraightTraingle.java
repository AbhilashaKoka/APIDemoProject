package org.example.Number;

public class StraightTraingle {
    public static void main(String[] args) {
    straightPyramid(5);
    }
    public static void straightPyramid(int n){
        for(int i=1; i<=n;i++){
            for(int j=1; j<=i;j++)
            {
                System.out.print("*");

            }
            System.out.println( );

        }
    }
}
