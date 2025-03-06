package be.hanagami.exmpleAlibou;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Test {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @org.junit.jupiter.api.Test
    public void testMethod1(){
        System.out.println("testMethod1");
    }

    @org.junit.jupiter.api.Test
    public void testMethod2(){
        System.out.println("testMethod2");
    }
}
