package org.example.javaDemo.Number;

import java.util.Scanner;

public class RightTrianglePattern{
    public static void main(String[] args)
    {
        RightTraiangle();
        LeftTrianglePattern();
        PyramidPattern();
        DiamondPattern();
    }

    static void RightTraiangle(){
        int i, j, row=6;
        for(i=0;i<row;i++){
            for(j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void LeftTrianglePattern(){
        int i, j, row=6;
        for(i=0;i<row;i++){
            for(j=2*(row-i);j>=0;j--){
                System.out.print(" ");
            }
            for(j=0;j<=i;j++){
                System.out.print("* ");
            }
             System.out.println();
        }
    }

    static void PyramidPattern(){
        int i, j, row=6;
        for(i=0;i<row;i++){
            for(j=row-i;j>1;j--)
                {
                  System.out.print(" ");
                 }
            for(j=0;j<=i;j++){
                  System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void DiamondPattern(){
        int row, i, j, space=1;
        System.out.print("Enter the number of rows you want to print:");
        Scanner sc=new Scanner(System.in);
        row=sc.nextInt();
        space=row-1;

        for(j=1;j<=row;j++){
            for(i=1;i<=space;i++){
                System.out.print(" ");
            }
            space--;
            for(i=1;i<=2*j-1;i++){
                System.out.print("*");
            }
            System.out.println();
        }
        space=1;

        for(j=1;j<=row-1;j++){
            for(i=1;i<=space;i++)
            {
                 System.out.print(" ");
            }
            space++;
            for(i=1;i<=2*(row-j)-1;i++)
            {
                System.out.print("*");
            }
              System.out.println(" ");
        }
    }
}
