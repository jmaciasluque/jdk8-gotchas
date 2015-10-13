package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class Replace extends Printer {

    public static void main(String[] args) {

        println(">>> Map.replace(K key,\n" +
                "                V oldValue,\n" +
                "                V newValue)");
        println("\n * Behaviour: replaces the entry for the specified key only if currently mapped to the specified value.\n");
        println(" * GOTCHA: Quite resilient to null key's and value's... no NullPointerException's!\n");

        Map<Integer, String> replace1 = new HashMap<>();
        replace1.put(1, "One");
        replace1.put(2, "Two");
        println("replace1 ==> " + replace1);
        boolean result1 = replace1.replace(1, "One", "NewOne");
        println("replace1 after replace1.replace(1, \"One\", \"NewOne\"); ==> " + replace1 + ". Returned " + result1 + "\n");

        Map<Integer, String> replace2 = new HashMap<>();
        replace2.put(1, "One");
        replace2.put(2, "Two");
        println("replace2 ==> " + replace2);
        boolean result2 = replace2.replace(1, "Two", "NewTwo");
        println("replace2 after replace2.replace(1, \"Two\", \"NewTwo\"); ==> " + replace2 + ". Returned " + result2 + "\n");

        Map<Integer, String> replace3 = new HashMap<>();
        replace3.put(1, "One");
        replace3.put(2, "Two");
        println("replace3 ==> " + replace3);
        boolean result3 = replace3.replace(2, "One", "NewOne");
        println("replace3 after replace3.replace(2, \"One\", \"NewOne\"); ==> " + replace3 + ". Returned " + result3 + "\n");

        Map<Integer, String> replace4 = new HashMap<>();
        replace4.put(1, "One");
        replace4.put(2, "Two");
        println("replace4 ==> " + replace4);
        boolean result4 = replace4.replace(null, null, null);
        println("replace4 after replace4.replace(null, null, null); ==> " + replace4 + ". Returned " + result4 + "\n");

        Map<Integer, String> replace5 = new HashMap<>();
        replace5.put(null, "One");
        replace5.put(2, "Two");
        println("replace5 ==> " + replace5);
        boolean result5 = replace5.replace(null, "One", "NewOne");
        println("replace5 after replace5.replace(null, \"One\"); ==> " + replace5 + ". Returned " + result5 + "\n");

        Map<Integer, String> replace6 = new HashMap<>();
        replace6.put(1, null);
        replace6.put(2, "Two");
        println("replace6 ==> " + replace6);
        boolean result6 = replace6.replace(1, null, null);
        println("replace6 after replace6.replace(1, null, null); ==> " + replace6 + ". Returned " + result6);
        println(" * GOTCHA: even if the newValue is the same as the old, it returns true!");
        
        Map<Integer, String> replace7 = new HashMap<>();
        replace7.put(1, "One");
        replace7.put(2, "Two");
        println("replace7 ==> " + replace7);
        boolean result7 = replace7.replace(1, "One", "One");
        println("replace7 after replace7.replace(1, \"One\", \"One\"); ==> " + replace7 + ". Returned " + result7);
        println(" * GOTCHA: even if the newValue is the same as the old, it returns true!");
    }
}