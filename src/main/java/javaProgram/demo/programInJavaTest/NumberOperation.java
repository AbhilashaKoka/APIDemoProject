package javaProgram.demo.programInJavaTest;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class NumberOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthdate(yyyy-mm-dd):");
        String birthdateString = scanner.nextLine();
        scanner.close();
        calculateAge(birthdateString);
        int number = 370;
        checkArmstrongNo(number);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Diamond Shape Pattern Generator");
        System.out.print("Enter the number of rows for half of the diamond: ");
        int numRows = scanner1.nextInt();
        diamondPattern(numRows);
        scanner1.close();
        int number1 = 4;
        long factorial = factorial(number1);
        System.out.println("Factorial of number" + factorial);
        int terms = 10;
        fibonacciSeriesMethod(terms);
        int count = 10;
        System.out.println("Fibonnacci series up to " + count + "number:");
        for (int i = 0; i <= count; i++) {
            System.out.println(fibonacci(i) + " ");
        }
        int limit = 50;
        findPrimeSeries(limit);

        int number11 = 48;
        int number22 = 18;
        System.out.println("The GCD of" + number1 + "and" + number22 + " is:" + gcd(number11, number22));
        invertedTriangle(5);
        int num1 = 10, num2 = 20, num3 = 30;
        largestOfThreeNumber(num1, num2, num3);

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Enter the number up to which you want the sum:");
        int n = scanner3.nextInt();
        int sum = calculateSum(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        int n10 = 100;
        sumOfNaturalNumber(n10);
        straightPyramid(5);
        int originalNumber = 12345;
        int reversedNumber = reverse(originalNumber);
        System.out.println("Original Number: " + originalNumber);
        System.out.println("Reversed Number: " + reversedNumber);
        int number34 = 17;
        if (isPrime(number)) {
            System.out.println(number34 + " is a prime number!");
        } else {
            System.out.println(number34 + " is not a prime number.");
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sides of Triangle");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        determineType(a, b, c);
        int start = 10;
        int end = 50;

        System.out.println("Prime number between" + start + "and" + end + ":");
        isPrime2(100);
    }

    public static boolean isPrime2(int number){
        if(number<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++)
        {
            if(number%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static void determineType(int a, int b, int c) {
        if(a >= (b+c) || c >= (b+a) || b >= (a+c) )
        {
            System.out.println("Not a Triangle");
        }
        else if(a==b && b==c)
        {
            System.out.println("Equilateral Triangle");
        }
        else if (((a * a) + (b * b)) == (c * c) || ((a * a) + (c * c)) == (b * b) || ((c * c) + (b * b)) == (a * a)) {
            System.out.println("Right Triangle");
        }
        else if(a!=b && b!=c && c!=a)
        {
            System.out.println("Scalene Triangle");
        }
        else if ((a==b && b!=c ) || (a!=b && c==a) || (c==b && c!=a))
        {
            System.out.println("Isosceles Triangle");
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2)
        {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrime(int num){
        if(num<=1)
            return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    public static int reverse(int number) {
        int reversed = 0;
        while(number != 0)
        {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        return reversed;
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

    public static void sumOfNaturalNumber(int n){
        int sumWithLoop=0;
        for(int i=1;i<=n;i++){
            sumWithLoop+=i;
        }
        int sumWithFormula=n*(n+1)/2;
        System.out.println("Sum using loop:"+sumWithLoop);
        System.out.println("Sum using formula:"+sumWithFormula);
    }

    public static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }
    public static void largestOfThreeNumber(int num1, int num2, int num3){
        int largest;
        if(num1>=num2&&num1>=num3){
            largest=num1;
        }
        else if(num2>=num1&&num2>=num3){
            largest=num2;
        }else{
            largest=num3;
        }
        System.out.println("The largest number is:"+largest);
    }

    public  static void invertedTriangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("*");
            }
            System.out.println( );
        }
    }
    public static int gcd(int num1, int num2){
        while(num1!=num2){
            if(num1>num2)
                num1=num1-num2;
            else num2=num2-num1;
        }
        return num1;
    }
    public static  void findPrimeSeries(int limit){
        System.out.println("Prime Numbers up to "+ limit +":");
        for(int number=2; number<=limit; number++)
        {
            boolean isPrime=true;
            for(int i=2; i<=number/2; i++){
                if(number%i==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
            {
                System.out.println(number+" ");
            }
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void fibonacciSeriesMethod(int terms){
        int firstTerm=0;
        int secondTerm=1;
        for(int i=1;i<=terms;++i)
        {
            System.out.println(firstTerm+" ");
            int nextTerm=firstTerm+secondTerm;
            firstTerm=secondTerm;
            secondTerm=nextTerm;
        }
    }

    public static long factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    public static void diamondPattern(int numRows){
        for (int i = 1; i <= numRows; i++)
        {
            for (int j = numRows - i; j >= 1; j--){
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = numRows - 1; i >= 1; i--) {
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void checkArmstrongNo(int number){
        int originalNumber=number;
        int sum=0;

        //calculate the number of the digits
        int numberOfDigits=String.valueOf(number).length();
        while(number>0)
        {
            int digit=number%10;
            sum+=Math.pow(digit,numberOfDigits);
            number/=10;
        }

        if(sum==originalNumber)
        {
            System.out.println(originalNumber+"is a armstrong number");
        }
        else {
            System.out.println(originalNumber+"is not a armstrong number");
        }
    }

        public static void calculateAge(String birthdateString){
        LocalDate birthdate=LocalDate.parse(birthdateString);
        LocalDate currentDate=LocalDate.now();
        Period age= Period.between(birthdate, currentDate);
        System.out.println("You are"+age.getYears()+"year old");
    }
}
