package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class Compute extends Printer {

    public static void main(String[] args) {

        println(">>> Map.compute(K key,\n" +
                "                BiFunction<? super K,? super V,? extends V> remappingFunction)");
        println("\n * Behaviour: Attempts to compute a mapping for the specified key and its current mapped value (or null " +
                "if there is no current mapping).");
        println(" * GOTCHA: compute's remappingFunction works on key, value... merge on oldValue, newValue\n");

        Map<Integer, String> compute1 = new HashMap<>();
        compute1.put(1, "One");
        compute1.put(2, "Two");
        println("compute1 ==> " + compute1);
        compute1.compute(3, (key, value) -> "ThreeB");
        println("after compute1.compute(3, (key, value) -> \"ThreeB\") ==> " + compute1);

        Map<Integer, String> compute2 = new HashMap<>();
        compute2.put(1, "One");
        compute2.put(2, "Two");
        println("\ncompute2 ==> " + compute2);
        compute2.compute(2, (key, value) -> "TwoB");
        println("after compute2.compute(2, (key, value) -> \"TwoB\") ==> " + compute2);

        Map<Integer, String> compute3 = new HashMap<>();
        compute3.put(1, "One");
        compute3.put(2, "OldTwo");
        println("\ncompute3 ==> " + compute3);
        compute3.compute(2, (key, value) -> key + value);
        println("after compute3.compute(2, (key, value) -> oldValue + newValue) ==> " + compute3);

        Map<Integer, String> compute4 = new HashMap<>();
        compute4.put(1, "One");
        compute4.put(2, "OldTwo");
        println("\ncompute4 ==> " + compute4);
        compute4.compute(2, (key, value) -> Integer.toString(key));
        println("after compute4.compute(2, (key, value) -> Integer.toString(key)) ==> " + compute4);

        Map<Integer, String> compute5 = new HashMap<>();
        compute5.put(1, "One");
        compute5.put(2, "OldTwo");
        println("\ncompute5 ==> " + compute5);
        compute5.compute(2, (key, value) -> key + value);
        println("after compute5.compute(2, (key, value) -> key + value) ==> " + compute5);

        Map<Integer, String> compute6 = new HashMap<>();
        compute6.put(1, "One");
        compute6.put(2, null);
        println("\ncompute6 ==> " + compute6);
        compute6.compute(2, (key, value) -> null);
        println("after compute6.compute(2, (key, value) -> null) ==> " + compute6);
        
        Map<Integer, String> compute7 = new HashMap<>();
        compute7.put(1, "One");
        compute7.put(2, null);
        println("\ncompute7 ==> " + compute7);
        compute7.compute(2, (key, value) -> key + value);
        println("after compute7.compute(2, (key, value) -> key + value) ==> " + compute7);
    }
}