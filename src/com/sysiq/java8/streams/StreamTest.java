package com.sysiq.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamTest {

    public static void echoInteger(Integer i) {
        System.out.println("echoInteger: " + i);
    }

    @Test
    public void testStream() {
        Consumer<Integer> echoInt = StreamTest::echoInteger;

        List<Integer> list = Arrays.asList(4, 5, 6, 1, 2, 3);
        list.stream()
                .filter((x) -> x > 3)
                .sorted(Integer::compare)
                .forEach(echoInt);

        System.out.println("=====================");
        list.forEach(echoInt);
        list.sort(Integer::compare);

        System.out.println("=====================");
        list.forEach(StreamTest::echoInteger);
    }



}
