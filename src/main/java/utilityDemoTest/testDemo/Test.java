package utilityDemoTest.testDemo;

public class Test {
    public void print(Integer i){
        System.out.println("Integer");
      }

    public void print(int i){
        System.out.println("int");
    }

    public void print(long i){
        System.out.println("long");
    }


    public static void main(String[] args){
        Test test=new Test();
   //   test.print(10);//int
        int i=10;
        Integer i1=Integer.valueOf(i);
        test.print(Integer.valueOf(i));
    }
}

