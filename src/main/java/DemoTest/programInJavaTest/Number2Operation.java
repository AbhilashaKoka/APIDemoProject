package DemoTest.programInJavaTest;
import java.util.Scanner;

public class Number2Operation {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the limit");
        num = scanner.nextInt();
        if (isArmstrong(num)) {
            System.out.println("Armstrong");
        } else {
            System.out.println("Not Armstrong");
        }
        int[] arr = new int[]{1, 2, 3, 4, 5};
        elementInEvenPosition(arr);
        int i, fact = 1;
        int number = 4;

        fact = factorial(number);
        System.out.println("Factorial of" + number + "is:" + fact);

        int a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number");
        a = sc.nextInt();
        System.out.println("Enter the Second Number");
        b = sc.nextInt();
        System.out.println("Enter the third Number");
        c = sc.nextInt();
        largestOfThreeNumber(a, b, c);
        int n = 454;
        palindromeMethod(n);
        int min = 200, max = 400;
        ramdomNumbermethod(min, max);
        int number1 = 987654;
        reverseNumberMethod(number1);

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
    public static void reverseNumberMethod(int number){
        int reverse = 0;
        while(number!=0){
            int reminder=number%10;
            reverse=reverse*10+reminder;
            number=number/10;
        }
        System.out.println("The reverse of the given number is "+reverse);

    }

    public static void ramdomNumbermethod(int min, int max){
        System.out.println("Random value of type double between"+min+"to"+max+":");
        double a=Math.random()*(max-min+1)+min;
        System.out.println(a);
        System.out.println("Random value of type double between "+min+" to "+max+":");
        int b=(int)(Math.random()*(max-min+1)+min);
        System.out.println(b);
    }

    public static void palindromeMethod(int n){
        int r, sum = 0, temp;
        temp = n;
        while(n>0){
            r= n% 10;
            sum= (sum * 10)+ r;
            n= n/10;
        }
        if(temp==sum)
            System.out.println("palindrome number");
        else
            System.out.println("not palindrome");
        palindromeExample();
        checkPrime(1);
    }


    static void checkPrime(int n)
    {
        int i, m=0, flag=0;

        m=n/2;

        if(n==0||n==1){
            System.out.println(n+"is not prime number");
        }

        else {
            for(i=2;i<=m;i++){
                if (n % i == 0){
                    System.out.println(n + "is not prime number");
                    flag = 1;
                    break;
                }
            }

            if(flag==0){
                System.out.println(n+"is Prime Number");
            }
        }
    }


    public static void palindromeExample(){
        String original, reverse = " ";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check is it is a palindrome");
        original=in.nextLine();
        int length=original.length();
        for(int i=length-1;i>=0;i--){
            reverse=reverse+original.charAt(i);
            if(original.equals(reverse))
                System.out.println("Entered string/number is a palindrome");
            else
                System.out.println("Entered string/number is`nt a palindrome");
        }
    }



    public static void largestOfThreeNumber(int a, int b, int c){
        int  largest=c>(a>b?a:b)?c:((a>b)?a:b);
        System.out.println("The largest number is :"+largest);

    }

    static int factorial(int n){
        if(n==0)
            return 1;
        else
            return (n*factorial(n-1));
    }

    public static void elementInEvenPosition(int[] arr){

        System.out.println("Element of given array");
        for(int i=1;i<arr.length;i=i+2){
            System.out.println(arr[i]);
        }
    }


 static boolean isArmstrong(int n) {
        int temp, digits = 0, last = 0, sum = 0;
        temp = n;

        while(temp > 0){
            temp = temp / 10;
            digits++;
        }

        temp = n;
        while(temp > 0) {
            last = temp % 10;
            sum += (Math.pow(last, digits));
            temp = temp / 10;
        }

     return n == sum;
    }


}

