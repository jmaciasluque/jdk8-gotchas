package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class Merge extends Printer {

    public static void main(String[] args) {

        println(">>> Map.merge(K key,\n" +
                "              V value,\n" +
                "              BiFunction<? super V,? super V,? extends V> remappingFunction)");
        println("\n * Behaviour: if the specified key is not already associated with a value or is associated with null, " +
                "associates it with the given non-null value. Otherwise, replaces the associated value with the results " +
                "of the given remapping function, or removes if the result is null.");
        println(" * GOTCHA: compute's remappingFunction works on key, value... merge on oldValue, newValue\n");

        Map<Integer, String> merge1 = new HashMap<>();
        merge1.put(1, "One");
        merge1.put(2, "Two");
        println("merge1 ==> " + merge1);
        merge1.merge(3, "Three", (oldValue, newValue) -> "ThreeB");
        println("after merge1.merge(3, \"Three\", (oldValue, newValue) -> \"ThreeB\") ==> " + merge1);

        Map<Integer, String> merge2 = new HashMap<>();
        merge2.put(1, "One");
        merge2.put(2, "Two");
        println("\nmerge2 ==> " + merge2);
        merge2.merge(2, "Two", (oldValue, newValue) -> "TwoB");
        println("after merge2.merge(2, \"Two\", (oldValue, newValue) -> \"TwoB\") ==> " + merge2);

        Map<Integer, String> merge3 = new HashMap<>();
        merge3.put(1, "One");
        merge3.put(2, "OldTwo");
        println("\nmerge3 ==> " + merge3);
        merge3.merge(2, "NewTwo", (oldValue, newValue) -> oldValue + newValue);
        println("after merge3.merge(2, \"NewTwo\", (oldValue, newValue) -> oldValue + newValue) ==> " + merge3);

        Map<Integer, String> merge4 = new HashMap<>();
        merge4.put(1, "One");
        merge4.put(2, "OldTwo");
        println("\nmerge4 ==> " + merge4);
//        merge4.merge(2, null, (oldValue, newValue) -> oldValue);
        println("after merge4.merge(2, null, (oldValue, newValue) -> oldValue) ==> NullPointerException if the newValue is null");
        println(" * GOTCHA: even if the newValue is not used to calculate the result, we'd get the NullPointerException");

        Map<Integer, String> merge5 = new HashMap<>();
        merge5.put(1, "One");
        merge5.put(2, "OldTwo");
        println("\nmerge5 ==> " + merge5);
//        merge5.merge(2, null, (oldValue, newValue) -> oldValue + newValue);
        println("after merge5.merge(2, null, (oldValue, newValue) -> oldValue + newValue) ==> NullPointerException if the newValue is null");

        Map<Integer, String> merge6 = new HashMap<>();
        merge6.put(1, "One");
        merge6.put(2, null);
        println("\nmerge6 ==> " + merge6);
        merge6.merge(2, "NewTwo", (oldValue, newValue) -> null);
        println("after merge6.merge(2, \"NewTwo\", (oldValue, newValue) -> null) ==> " + merge6);
        
        Map<Integer, String> merge7 = new HashMap<>();
        merge7.put(1, "One");
        merge7.put(2, null);
        println("\nmerge7 ==> " + merge7);
        merge7.merge(2, "NewTwo", (oldValue, newValue) -> oldValue + newValue);
        println("after merge7.merge(2, \"NewTwo\", (oldValue, newValue) -> oldValue + newValue) ==> " + merge7);
        println(" * GOTCHA: we don't get a NullPointerException here, even if the oldValue null is used when merging with the newValue");
    }
}