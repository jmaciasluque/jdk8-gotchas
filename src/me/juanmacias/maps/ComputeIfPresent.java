package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class ComputeIfPresent extends Printer {

    public static void main(String[] args) {

        println(">>> Map.computeIfPresent(K key,\n" +
                "                         BiFunction<? super K,? super V,? extends V> remappingFunction)");
        println("\n * Behaviour: if the value for the specified key is present and non-null, attempts to compute a new mapping " +
                "given the key and its current mapped value. If the function returns null, the mapping is removed. If the function " +
                "itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged.\n");

        println(" * GOTCHA: when the result of the computation to calculate the new value is null, the key is removed from the map");
        println(" * GOTCHA: it won't let you compute a new value for they key null (inconsistent with computeIfAbsent)");
        println(" * GOTCHA: returns the new value associated with the specified key, or null if none\n");

        Map<Integer, String> computeIfPresent1 = new HashMap<>();
        computeIfPresent1.put(1, "One");
        computeIfPresent1.put(2, "Two");
        println("computeIfPresent1 ==> " + computeIfPresent1);
        String result1 = computeIfPresent1.computeIfPresent(3, (k, v) -> {println("computing");return "New" + k + v;});
        println("computeIfPresent1 after computeIfPresent1.computeIfPresent(3, (k, v) -> {println(\"computing\");return \"New\" + k + v;}) ==> " + computeIfPresent1 + ". Returned " + result1 + "\n");

        Map<Integer, String> computeIfPresent2 = new HashMap<>();
        computeIfPresent2.put(1, "One");
        computeIfPresent2.put(2, "Two");
        println("computeIfPresent2 ==> " + computeIfPresent2);
        String result2 = computeIfPresent2.computeIfPresent(2, (k, v) -> {println("computing");return "New" + k + v;});
        println("computeIfPresent2 after computeIfPresent2.computeIfPresent(2, (k, v) -> {println(\"computing\");return \"New\" + k + v;}) ==> " + computeIfPresent2 + ". Returned " + result2 + "\n");

        Map<Integer, String> computeIfPresent3 = new HashMap<>();
        computeIfPresent3.put(1, "One");
        computeIfPresent3.put(2, "Two");
        println("computeIfPresent3 ==> " + computeIfPresent3);
        String result3 = computeIfPresent3.computeIfPresent(2, (k, v) -> {println("computing");return null;});
        println("computeIfPresent3 after computeIfPresent3.computeIfPresent(2, (k, v) -> {println(\"computing\");return null;}) ==> " + computeIfPresent3 + ". Returned " + result3 + "\n");

        Map<Integer, String> computeIfPresent4 = new HashMap<>();
        computeIfPresent4.put(1, "One");
        computeIfPresent4.put(2, "Two");
        computeIfPresent4.put(null, null);
        println("computeIfPresent4 ==> " + computeIfPresent4);
        String result4 = computeIfPresent4.computeIfPresent(null, (k, v) -> {println("computing");return "NotNull";});
        println("computeIfPresent4 after computeIfPresent4.computeIfPresent(null, (k, v) -> {println(\"computing\");return \"NotNull\";}) ==> " + computeIfPresent4 + ". Returned " + result4 + "\n");
    }
}