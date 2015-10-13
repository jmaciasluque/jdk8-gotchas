package me.juanmacias.maps;

import me.juanmacias.utils.Printer;
import java.util.HashMap;
import java.util.Map;


public class ComputeIfAbsent extends Printer {

    public static void main(String[] args) {

        println(">>> Map.computeIfAbsent(K key,\n" +
                "                        Function<? super K,? extends V> mappingFunction)");
        println("\n * Behaviour: if the specified key is not already associated with a value (or is mapped to null), attempts " +
                "to compute its value using the given mapping function and enters it into this map unless null. " +
                "If the function returns null no mapping is recorded. If the function itself throws an (unchecked) " +
                "exception, the exception is rethrown, and no mapping is recorded.");
        println(" * GOTCHA: it will NOT let you put a null value on the specified key if it was absent (different from putIfAbsent)");
        println(" * GOTCHA: it will let you, though, compute a value for the key null. NPE is possible, using the key when computing the new value");
        println(" * GOTCHA: it returns the current (existing or computed) value associated with the specified key, or null if the computed value is null.\n");

        Map<Integer, String> computeIfAbsent1 = new HashMap<>();
        computeIfAbsent1.put(1, "One");
        computeIfAbsent1.put(2, "Two");
        println("computeIfAbsent1 ==> " + computeIfAbsent1);
        String result1 = computeIfAbsent1.computeIfAbsent(3, i -> {println("computing");return Integer.toString(i);});
        println("computeIfAbsent1 after computeIfAbsent1.computeIfAbsent(3, i -> {println(\"computing\");return Integer.toString(i);}) ==> " + computeIfAbsent1 + ". Returned " + result1 + "\n");

        Map<Integer, String> computeIfAbsent2 = new HashMap<>();
        computeIfAbsent2.put(1, "One");
        computeIfAbsent2.put(2, "Two");
        println("computeIfAbsent2 ==> " + computeIfAbsent2);
        String result2 = computeIfAbsent2.computeIfAbsent(2, i -> {println("computing");return Integer.toString(i);});
        println("computeIfAbsent2 after computeIfAbsent2.computeIfAbsent(2, i -> {println(\"computing\");return Integer.toString(i);}) ==> " + computeIfAbsent2 + ". Returned " + result2 + "\n");

        Map<Integer, String> computeIfAbsent3 = new HashMap<>();
        computeIfAbsent3.put(1, "One");
        computeIfAbsent3.put(2, "Two");
        println("computeIfAbsent3 ==> " + computeIfAbsent3);
        String result3 = computeIfAbsent3.computeIfAbsent(3, i -> {println("computing");return null;});
        println("computeIfAbsent3 after computeIfAbsent3.computeIfAbsent(3, i -> {println(\"computing\");return null;}) ==> " + computeIfAbsent3 + ". Returned " + result3 + "\n");

        Map<Integer, String> computeIfAbsent4 = new HashMap<>();
        computeIfAbsent4.put(1, "One");
        computeIfAbsent4.put(2, "Two");
        println("computeIfAbsent4 ==> " + computeIfAbsent4);
        String result4 = computeIfAbsent4.computeIfAbsent(null, i -> {println("computing");return "not using key when computing new value";});
        println("computeIfAbsent4 after computeIfAbsent4.computeIfAbsent(null, i -> {println(\"computing\");return \"not using key when computing new value\";}) ==> " + computeIfAbsent4 + ". Returned " + result4 + "\n");

        Map<Integer, String> computeIfAbsent5 = new HashMap<>();
        computeIfAbsent5.put(1, "One");
        computeIfAbsent5.put(2, "Two");
        println("computeIfAbsent5 ==> " + computeIfAbsent5);
//        String result5 = computeIfAbsent5.computeIfAbsent(null, i -> {println("computing");return Integer.toString(i);});
        println("computeIfAbsent5 after computeIfAbsent5.computeIfAbsent(null, i -> {println(\"computing\");return Integer.toString(i);}) ==> Throws a NullPointerException, since i is null!\n");
    }
}