package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class PutIfAbsent extends Printer {

    public static void main(String[] args) {

        println(">>> Map.putIfAbsent(K key,\n" +
                "                    V value)");
        println("\n * Behaviour: if the specified key is not already associated with a value (or is mapped to null) " +
                "associates it with the given value and returns null, else returns the current value.");
        println(" * GOTCHA: it will let you put a null value on the specified key if it was absent (different from computeIfAbsent)\n");
        println(" * GOTCHA: when succeeding, it will return null in any case, even if the new value was not null. Weird.\n");

        Map<Integer, String> putIfAbsent1 = new HashMap<>();
        putIfAbsent1.put(1, "One");
        putIfAbsent1.put(2, "Two");
        println("putIfAbsent1 ==> " + putIfAbsent1);
        String result1 = putIfAbsent1.putIfAbsent(3, "Three");
        println("putIfAbsent1 after putIfAbsent1.putIfAbsent(3, \"Three\") ==> " + putIfAbsent1 + ". Returned " + result1 + "\n");

        Map<Integer, String> putIfAbsent2 = new HashMap<>();
        putIfAbsent2.put(1, "One");
        putIfAbsent2.put(2, "Two");
        println("putIfAbsent2 ==> " + putIfAbsent2);
        String result2 = putIfAbsent2.putIfAbsent(2, "NewTwo");
        println("putIfAbsent2 after putIfAbsent2.putIfAbsent(2, \"NewTwo\") ==> " + putIfAbsent2 + ". Returned " + result2 + "\n");

        Map<Integer, String> putIfAbsent3 = new HashMap<>();
        putIfAbsent3.put(1, "One");
        putIfAbsent3.put(2, "Two");
        println("putIfAbsent3 ==> " + putIfAbsent3);
        String result3 = putIfAbsent3.putIfAbsent(2, null);
        println("putIfAbsent3 after putIfAbsent3.putIfAbsent(2, null) ==> " + putIfAbsent3 + ". Returned " + result3 + "\n");

        Map<Integer, String> putIfAbsent4 = new HashMap<>();
        putIfAbsent4.put(1, "One");
        putIfAbsent4.put(2, "Two");
        println("putIfAbsent4 ==> " + putIfAbsent4);
        String result4 = putIfAbsent4.putIfAbsent(3, null);
        println("putIfAbsent4 after putIfAbsent4.putIfAbsent(3, null) ==> " + putIfAbsent4 + ". Returned " + result4 + "\n");

        Map<Integer, String> putIfAbsent5 = new HashMap<>();
        putIfAbsent5.put(1, "One");
        putIfAbsent5.put(2, "Two");
        println("putIfAbsent5 ==> " + putIfAbsent5);
        String result5 = putIfAbsent5.putIfAbsent(null, "Null");
        println("putIfAbsent5 after putIfAbsent5.putIfAbsent(null, \"Null\") ==> " + putIfAbsent5 + ". Returned " + result5 + "\n");
    
        Map<Integer, String> putIfAbsent6 = new HashMap<>();
        putIfAbsent6.put(1, "One");
        putIfAbsent6.put(2, "Two");
        println("putIfAbsent6 ==> " + putIfAbsent6);
        String result6 = putIfAbsent6.putIfAbsent(null, null);
        println("putIfAbsent6 after putIfAbsent6.putIfAbsent(null, null) ==> " + putIfAbsent6 + ". Returned " + result6 + "\n");
    }
}