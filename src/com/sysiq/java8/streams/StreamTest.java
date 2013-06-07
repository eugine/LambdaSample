package com.sysiq.java8.streams;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class StreamTest {

    @Test
    public void testLegacy() {
        List<Integer> list = Arrays.asList(5, 1, 6, 1, 2, 3, 4);

        List<Integer> result = new ArrayList<>();
        for (Integer item: list) {
            if (item > 3) {
                result.add(item);
            }
        }

        Collections.sort(result);

        for (Integer item: result) {
            System.out.println(item);
        }

    }

    @Test
    public void testStream() {
        List<Integer> list = Arrays.asList(5, 1, 6, 1, 2, 3, 4);
        list.stream()
                .filter((x) -> x > 3)
                .sorted(Integer::compare)
                .forEach(System.out::println);
    }

    @Test
    public void testMoreStream() {
        //sum
        int sum = IntStream.range(0, 5)
                .reduce((x, y) -> x + y)
                .getAsInt();
       Assert.assertEquals(10, sum);

        // x^2
        System.out.println("==== x^2: ");
        IntStream.range(0, 5)
                .map(x -> x*x)
                .forEach(System.out::println);

        //distinct
        System.out.println("==== Distinct, Limit, ForEach: ");
        Arrays.asList(1, 2, 1, 2, 3, 0, 1, 2, 1)
                .stream()
                .distinct()
                .sorted(Integer::compareTo)
                .limit(2)
                .forEach(System.out::println);

    }



}
