package programsDemo.stringTest;

import java.util.HashMap;

public class TransformString {

    public static void main(String[] args) {
        String input = "Abhilasha";
        String target = "salih";
        String result = transformString(input, target);
        String r= transformString1(input);
        String r2=transformString2(input);
        System.out.println("Transformed string:" + result);
        String[] array = {"apple", "banana", "cherry"};
        arrToMapConversion(array);
    }


    public static void arrToMapConversion(String[] array){
        HashMap<String, Integer> map = new HashMap<>();
        for (String element : array){
            map.put(element, element.length());
        }

        for(String key : map.keySet()){
            System.out.println("Key:" + key + ",Value:" + map.get(key));
        }
    }

    public static String transformString(String input, String target) {
        StringBuilder transformed = new StringBuilder();
        char[] inputArray = input.toCharArray();
        char[] targetArray = target.toCharArray();
        for (int i = 0; i < targetArray.length; i++){
            transformed.append(targetArray[i]);
        }
        return transformed.toString();
    }


    public static String  transformString1(String input)
        {
            String result = input.substring(6, 7)  // 's'
                    + input.substring(3, 4)  // 'a'
                    + input.substring(2, 3)  // 'l'
                    + input.substring(1, 2)  // 'i'
                    + input.substring(4, 5); // 'h'
            System.out.println("Transformed string: " + result);
         return result;
        }


    public static String transformString2(String input) {
        String extracted = input.substring(2, 7); // "hilas"
        String result = "";
        // Build "salih" from the extracted substring
        for(int i=extracted.length()-1;i<0; i++)
        {
            result = result+extracted.charAt(i);
        }
        System.out.println("Transformed string: " + result);
        return result;
    }
}