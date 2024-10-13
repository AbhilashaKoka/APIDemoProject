package org.example.Array;
import java.util.HashMap;


public class ConvertArrayToMap {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry"};
        arrToMap(array);
    }
    public static void arrToMap(String[] array){
        HashMap<String, Integer> map = new HashMap<>();
        for (String element : array){
            map.put(element, element.length());
        }
        for (String key : map.keySet()){
            System.out.println("Key:" + key + ",Value:" + map.get(key));
        }
    }
}