package com.sysiq.java8.lambda;

import org.junit.Test;

public class LambdaTest {

    @Test
    public void test () {
        LambdaInterface0 i0 = () -> System.out.println("interface");

        Runnable r1 = () -> System.out.println("running");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous classes: running");
            }
        };


        LambdaInterface0 i0_long = new LambdaInterface0() {
            @Override
            public void apply() {
                System.out.println("interface long");
            }
        };
        i0_long.apply();
        i0_long = i0;
        i0_long.apply();

        LambdaInterface1 li1 = (x) -> Integer.toString(x);

        LambdaInterface2 li2 = (x, y) -> Integer.compare(x, y);

        System.out.println(li2.apply(10, 11));

        LambdaInterface2 li2_1 = Integer::compare;

    }

}
