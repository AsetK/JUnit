package com.epam.mockito;

import com.epam.service.CalculatorService;
import com.epam.service.MyMath;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyMathMockitoTest {

    MyMath myMath = null;

    @Mock
    CalculatorService service;  // Creating fake instance of CalculatorService
    //Or we can:
//    CalculatorService service = mock(CalculatorService.class); // Creating fake instance of CalculatorService

    @Rule
    public MockitoRule rule = MockitoJUnit.rule(); // For @Mock annotation

    @Before
    public void setUp() throws Exception {
        myMath = new MyMath(service); // Manually adding dependency. Instead we can use - @InjectMocks.
    }

    @Test
    public void mult() {
        int a = 2;
        int b = 3;
        int expResult = 6;

        when(service.mult(a,b)).thenReturn(expResult);
        int result = this.myMath.mult(a,b);

//        when(service.mult(this.a,this.b)).thenReturn(this.expResult);  // Parameterized version
//        int result = this.myMath.mult(this.a,this.b);

        assertEquals(expResult, result);
        verify(service).mult(a,b); //checks if mocked object used. If we in MyMath instead CalculatorService will use own logic, for example 2*3, test will fail.
    }
}
