package org.example.Number;

public class InvertedPyramidShape {
    public static void main(String[] args) {
        invertedTriangle(5);
    }

    public  static void invertedTriangle(int n){
         for(int i=1;i<=n;i++){
             for(int j=n;j>=i;j--){
                 System.out.print("*");
             }
             System.out.println( );
         }
    }
}
