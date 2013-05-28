package com.sysiq.java8.lambda;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Predicate;

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

    @Test
    public void testPredicate() {
        // Predicate<T> - boolean test(T t)
        Predicate<String> isTrue = "true"::equalsIgnoreCase;

        Assert.assertTrue(isTrue.test("TruE"));
        Assert.assertTrue(isTrue.test("TRUE"));
        Assert.assertFalse(isTrue.test("False"));
    }

}
