package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class Remove extends Printer {

    public static void main(String[] args) {

        println(">>> Map.remove(Object key,\n" +
                "               Object value)");
        println("\n * Behaviour: removes the entry for the specified key only if it is currently mapped to the specified value.");
        println(" * GOTCHA: Quite resilient to null key's and value's... no NullPointerException's!\n");

        Map<Integer, String> remove1 = new HashMap<>();
        remove1.put(1, "One");
        remove1.put(2, "Two");
        println("remove1 ==> " + remove1);
        boolean result1 = remove1.remove(1, "One");
        println("remove1 after remove1.remove(1, \"One\"); ==> " + remove1 + ". Returned " + result1 + "\n");

        Map<Integer, String> remove2 = new HashMap<>();
        remove2.put(1, "One");
        remove2.put(2, "Two");
        println("remove2 ==> " + remove2);
        boolean result2 = remove2.remove(1, "Two");
        println("remove2 after remove2.remove(1, \"Two\"); ==> " + remove2 + ". Returned " + result2 + "\n");

        Map<Integer, String> remove3 = new HashMap<>();
        remove3.put(1, "One");
        remove3.put(2, "Two");
        println("remove3 ==> " + remove3);
        boolean result3 = remove3.remove(2, "One");
        println("remove3 after remove3.remove(2, \"One\"); ==> " + remove3 + ". Returned " + result3 + "\n");

        Map<Integer, String> remove4 = new HashMap<>();
        remove4.put(1, "One");
        remove4.put(2, "Two");
        println("remove4 ==> " + remove4);
        boolean result4 = remove4.remove(null, null);
        println("remove4 after remove4.remove(null, null); ==> " + remove4 + ". Returned " + result4 + "\n");

        Map<Integer, String> remove5 = new HashMap<>();
        remove5.put(null, "One");
        remove5.put(2, "Two");
        println("remove5 ==> " + remove5);
        boolean result5 = remove5.remove(null, "One");
        println("remove5 after remove5.remove(null, \"One\"); ==> " + remove5 + ". Returned " + result5 + "\n");

        Map<Integer, String> remove6 = new HashMap<>();
        remove6.put(1, null);
        remove6.put(2, "Two");
        println("remove6 ==> " + remove6);
        boolean result6 = remove6.remove(1, null);
        println("remove6 after remove6.remove(1, null); ==> " + remove6 + ". Returned " + result6 + "\n");
    }
}