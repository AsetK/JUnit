package com.epam.mockito;

import com.epam.service.CalculatorService;
import com.epam.service.MyMath;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyMathMockitoTest_InjectMocks {

    @InjectMocks
    MyMath myMath;

    @Mock
    CalculatorService service; //Another example - dao

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // Initializes fields annotated with Mockito annotations.
    }

    @Test
    public void mult() {
        int a = 2;
        int b = 3;
        int expResult = 6;

        when(service.mult(a,b)).thenReturn(expResult);
        int result = this.myMath.mult(a,b);

        assertEquals(expResult, result);
        verify(service).mult(a,b);
    }


}
