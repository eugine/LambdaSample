package com.sysiq.java8.defaults;

import org.junit.Test;

public class MultipleInheritanceTest {

    interface I1 {
        default void doSomething() {
            System.out.println("I1 do something");
        }
    }

    interface I2 {
        default void doSomething() {
            System.out.println("I2 do something");
        }
    }

    interface I3 extends I1, I2 {
        default void doSomething() {

        }
    }

    class C1 implements I1 {

    }

    class C2 implements I2 {

    }

    class C3 implements I1, I2 {

        public void doSomething() {

        }

    }

    @Test
    public void multipleInheritanceTest() {
        I3 i = new I3(){};
    }


}
