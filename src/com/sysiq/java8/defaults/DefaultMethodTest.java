package com.sysiq.java8.defaults;

import org.junit.Test;

public class DefaultMethodTest {

    //=============================================
    //
    // Default method in Interface
    //
    //=============================================


    public interface SimpleInterface {

        public void doSomeWork();

        public default void doSomeOtherWork() {
            System.out.println("Other work: done by Simple Interface.");
        }

    }

    @Test
    public void testDefaultMethod() {
        SimpleInterface si = () ->
                System.out.println("Work: done by Simple Anonymous Impl.");

        si.doSomeWork();
        si.doSomeOtherWork();

    }

    //=============================================
    //
    // Functional Interface for Lambda's with default method
    //
    //=============================================


    //    @FunctionalInterface
    public interface SimpleLambdaInterface {

        public void doSomeWork();

        //        public void doFreelanceWork();
        public default void doSomeOtherWork() {
            System.out.println("Other Work: done by Simple Lambda Interface");
        }

    }

    @Test
    public void testLambdaDefaultMethod() {
        SimpleLambdaInterface sli = () -> System.out.println("Work: done by Simple Lambda Impl");

        sli.doSomeWork();
        sli.doSomeOtherWork();
    }

    //=============================================
    //
    // Static method in Interface
    //
    //=============================================

    public interface SimpleStaticInterfaceMethod {

        static void doSomeStaticWork() {
            System.out.println("Static Work: done by Simple Static Method Interface");
        }

    }

    @Test
    public void testStaticInterfaceMethod() {
        SimpleStaticInterfaceMethod.doSomeStaticWork();
    }


}
