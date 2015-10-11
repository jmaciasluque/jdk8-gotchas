package me.juanmacias.maps;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Maps {

    public static void main(String[] args) {

        Map<Integer,String> numbers = new HashMap<Integer,String>();
        numbers.put(1, "one");
        numbers.put(2, "Two");
        Map<Integer,String> numbers2 = new HashMap<Integer,String>();
        numbers2.put(3, "Three");
        numbers2.put(4, "Four");
        BiFunction<String,String,String> func = (k,v) -> v;
        BiConsumer<Integer,String> cons = (k,v) -> numbers.merge(k, v, func);
        numbers2.forEach(cons);
        System.out.println(numbers);


        Map<Integer,String> numbers3 = new HashMap<Integer,String>();
        numbers3.put(1, "one");
        numbers3.put(2, "Two");
        numbers3.merge(1,"One",(s,v) -> null);
        System.out.println(numbers3);

    }

}
