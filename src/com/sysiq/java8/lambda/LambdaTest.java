package com.sysiq.java8.lambda;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    @Test
    public void testLegacy () {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable legacy");
            }
        };

        Comparator<Integer> cmp =  new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x > y) ? 1 : (x < y) ? -1 : 0;
            }
        };

        r.run();
        Assert.assertEquals(1,  cmp.compare(100, 10));
        Assert.assertEquals(0,  cmp.compare(200, 200));
        Assert.assertEquals(-1, cmp.compare(100, 101));
    }

    @Test
    public void testLambda() {
        // Runnable - void run()
        Runnable r = () -> System.out.println("runnable lambda");

        // Comparator<T> - int compare(T x, T y)
        Comparator<Integer> cmp =  (Integer x, Integer y) -> (x > y) ? 1 : (x < y) ? -1 : 0;

        r.run();
        Assert.assertEquals(1,  cmp.compare(100, 10));
        Assert.assertEquals(0,  cmp.compare(200, 200));
        Assert.assertEquals(-1, cmp.compare(100, 101));
    }

    public interface NotFunctionalInterface<T> {
        public T action(T t);
//        public void action2();
    }

    @Test
    public void testNotFunctionalInterface() {
        // NotFunctionalInterface<T> - T action(T t)
        NotFunctionalInterface<String> nfi = s -> s;
    }


    //=============================================================
    //
    //method references
    //
    //=============================================================

    @Test
    public void testStaticMethodRef() {
        // Comparator<T> - T compare(T x, T y)
        Comparator<Integer> cmp_legacy = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        Comparator<Integer> cmp_lambda = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> cmp = Integer::compare;

        Assert.assertEquals(1,  cmp.compare(100, 10));
        Assert.assertEquals(0,  cmp.compare(200, 200));
        Assert.assertEquals(-1, cmp.compare(100, 101));

    }

    public static void echoInteger(Integer i) {
        System.out.println("echoInteger: " + i);
    }

    @Test
    public void testStaticMethodRef2() {
        Consumer<Integer> echoInt_extended = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                LambdaTest.echoInteger(i);
            }
        };
        // Consumer<T> - accept(T t)
        Consumer<Integer> echoInt = LambdaTest::echoInteger;

        List<Integer> list = Arrays.asList(4, 5, 6, 1, 2, 3);
        list.sort(Integer::compare);
        list.forEach(echoInt);

    }

    @Test
    public void testInstanceMethodRef() {
        // Predicate<T> - boolean test(T t)
        // String - boolean equalsIgnoreCase(String s)
        Predicate<String> isTrue = "true"::equalsIgnoreCase;

        //Consumer<T> - void apply(T t)
        Consumer<String> print = System.out::println;

        Assert.assertTrue(isTrue.test("TruE"));
        Assert.assertTrue(isTrue.test("TRUE"));
        Assert.assertFalse(isTrue.test("False"));

        Arrays.asList("Foo", "Bar", "Baz")
                .forEach(print);
    }

    public class Lambda {

        private String lambda = "lambda";

        public Lambda() {
        }

        public Lambda(String lambda) {
            this.lambda = lambda;
        }

        public String getLambda() {
            return lambda;
        }
    }

    @Test
    public void testConstructorMethodRef() {
        Supplier<Lambda> lambda = Lambda::new;
        Function<String, Lambda> lambda2 = Lambda::new;
        Function<String, Integer> f1 = Integer::new;

        Assert.assertEquals("lambda", lambda.get().getLambda());
        Assert.assertEquals("lambda2", lambda2.apply("lambda2").getLambda());
        Assert.assertEquals(123, f1.apply("123").intValue());
    }

}
