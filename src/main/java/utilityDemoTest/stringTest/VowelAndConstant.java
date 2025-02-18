package utilityDemoTest.stringTest;


public class VowelAndConstant {
    public static void main(String[] args) {
        int vCount=0, cCount=0;
        String str="This is a real simple sentence";
        str.toLowerCase();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'|| str.charAt(i)=='i'|| str.charAt(i)=='0'||str.charAt(i)=='u'){
                vCount++;
            }
            else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                cCount++;
            }
        }
        System.out.println(vCount);
        System.out.println(cCount);
    }
}
