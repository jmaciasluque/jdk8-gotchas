package me.juanmacias.arrays;

import me.juanmacias.utils.Printer;

import java.util.Arrays;
import java.util.stream.IntStream;


public class ArraysParallels extends Printer {

    public static void main(String[] args) {

        println(">>> Arrays.parallelSetAll()");
        println("\n * Behaviour: set all elements of the specified array, using the provided generator function to compute each element.");
        println(" * GOTCHA: i ALWAYS makes reference to the current index!\n");

        int[] intsToBeSet = new int[10];
        Arrays.parallelSetAll(intsToBeSet, i -> i + 18);
        IntStream.Builder builder = IntStream.builder();
        for (int i: intsToBeSet) { builder.accept(i); }
        print("Arrays.parallelSetAll(new int[10], i -> i + 18) ==> ");
        builder.build().forEach(number -> print(number + " "));
        println("\n\nThe generator can be, then: \n\n" +
                "- An IntFunction<T>: for that, the array passed would have to be T[].\n" +
                "- An IntUnaryOperator: for that, the array passed would have to be int[].\n" +
                "- An IntToLongFunction: for that, the array passed would have to be long[].\n" +
                "- An IntToDoubleFunction: for that, the array passed would have to be double[].\n");

        println(">>> Arrays.parallelPrefix()\n");
        println(" * Behaviour: accumulates, in parallel, each element of the given array in place, using the supplied function.");
        println(" * GOTCHA: the first element is NEVER affected!\n");

        double[] doubles = {1.0, 2.0, 3.0};
        Arrays.parallelPrefix(doubles, (i1, i2) -> i1 * (i2 + 3.5));
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0}, (i1, i2) -> i1 * (i2 + 3.5))[0] ==> " + doubles[0]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0}, (i1, i2) -> i1 * (i2 + 3.5))[1] ==> " + doubles[1]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0}, (i1, i2) -> i1 * (i2 + 3.5))[2] ==> " + doubles[2]);
        println("\nThe operator can be: \n\n" +
                "- DoubleBinaryOperator, which will operate on a double[].\n" +
                "- IntBinaryOperator, which will operate on a int[].\n" +
                "- LongBinaryOperator, which will operate on a long[].\n" +
                "- BinaryOperator<T>, which will operate on a T[].\n");

        println(" * Behaviour: accumulates, in place and in parallel, the elements of the given range of the given array, using the supplied function.");
        println(" * GOTCHA: the first element of the range is NEVER affected!");
        println(" * GOTCHA: end of the range is EXCLUSIVE!");

        double[] moreDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        Arrays.parallelPrefix(moreDoubles, 1, 3, (i1, i2) -> i1 * (i2 + 3.5));
        println("\nArrays.parallelPrefix(new double[] {1.0, 2.0, 3.0, 4.0, 5.0}, 1, 3, (i1, i2) -> i1 * (i2 + 3.5))[0] ==> " + moreDoubles[0]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0, 4.0, 5.0}, 1, 3, (i1, i2) -> i1 * (i2 + 3.5))[1] ==> " + moreDoubles[1]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0, 4.0, 5.0}, 1, 3, (i1, i2) -> i1 * (i2 + 3.5))[2] ==> " + moreDoubles[2]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0, 4.0, 5.0}, 1, 3, (i1, i2) -> i1 * (i2 + 3.5))[3] ==> " + moreDoubles[3]);
        println("Arrays.parallelPrefix(new double[] {1.0, 2.0, 3.0, 4.0, 5.0}, 1, 3, (i1, i2) -> i1 * (i2 + 3.5))[4] ==> " + moreDoubles[4]);
        println("\n * The operator can be: \n\n" +
                "- DoubleBinaryOperator, which will operate on a double[].\n" +
                "- IntBinaryOperator, which will operate on a int[].\n" +
                "- LongBinaryOperator, which will operate on a long[].\n" +
                "- BinaryOperator<T>, which will operate on a T[].\n");

        println(">>> Arrays.parallelSort()");
        println("\n * Behaviour: sorts the specified array into ascending numerical order.");
        println(" * GOTCHA: the first element is NEVER affected!");

        long[] longsToSort = {78, 34, 12, 9, 4, -5, 1};
        Arrays.parallelSort(longsToSort);
        println("\nArrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[0] ==> " + longsToSort[0]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[1] ==> " + longsToSort[1]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[2] ==> " + longsToSort[2]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[3] ==> " + longsToSort[3]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[4] ==> " + longsToSort[4]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[5] ==> " + longsToSort[5]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1})[6] ==> " + longsToSort[6]);

        println("\n * Behaviour: sorts the specified range of the array into ascending numerical order.");
        println(" * GOTCHA: end of the range is EXCLUSIVE!");

        long[] longsToSortAgain = {78, 34, 12, 9, 4, -5, 1};
        Arrays.parallelSort(longsToSortAgain, 0, 3);
        println("\nArrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[0] ==> " + longsToSortAgain[0]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[1] ==> " + longsToSortAgain[1]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[2] ==> " + longsToSortAgain[2]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[3] ==> " + longsToSortAgain[3]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[4] ==> " + longsToSortAgain[4]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[5] ==> " + longsToSortAgain[5]);
        println("Arrays.parallelSort(new long[] {78, 34, 12, 9, 4, -5, 1}, 0, 3)[6] ==> " + longsToSortAgain[6]);

        println("\n * Other primitive versions: byte[], char[], double[], float[], int[], short[]");
        println(" * Other version: T[], which also offers the chance of specifying a Comparator, always last parameter, with or without a range specified!");
    }
}
