package com.epam.junit;

import com.epam.service.MyMath;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class) //for Parameterized testing
public class MyMathTest {
    int a;                                              // For Parameterized testing
    int b;
    int expResult;

    public MyMathTest(int a, int b, int expResult) {    // For Parameterized testing
        this.a = a;
        this.b = b;
        this.expResult = expResult;
    }

    @Rule
    public TestRule timeout = new Timeout(500);   // Common rule for all @Test


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Parameterized.Parameters                           // For Parameterized testing
    public static Collection numbers() { //or Iterable<Object[]>
        return Arrays.asList(new Object[][]{{1,2,3},{2,3,5},{3,3,7}});
//        or
//        ArrayList<Object[]> list = new ArrayList();
//        list.add(new Object[]{1,2,3});
//        list.add(new Object[]{2,3,5});
//        list.add(new Object[]{2,2,4});
//        return list;
    }


    @Test
    public void add() {
//        int a = 3;
//        int b = 2;
//        int expResult = a+b;
        int result = MyMath.add(a,b);

        assertEquals(expResult,result);
    }

    @Test
    @Ignore
    public void sub() {
        int a = 3;
        int b = 2;
        int expResult = a-b;
        int result = MyMath.sub(a,b);

        assertEquals(expResult,result);
    }

    @Ignore
    @Test(expected = ArithmeticException.class) //When we expect some Exception. If no exception - test fails!
    public void div() {
        int a = 3;
        int b = 0;
        int expResult = a/b;
        int result = MyMath.div(a,b);

        assertEquals(expResult,result);
    }

    @Test
    public void isZero(){
        int a = 0;
        assertTrue(MyMath.isZero(a));
    }
}