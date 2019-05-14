package com.epam.spock

import com.epam.service.MyMath

class MyMathTest extends spock.lang.Specification {
    def Add() {
        expect:
            MyMath.add(2,3) == 4;
    }

    def IsZero() {
        setup:
            def obj = new MyMath();
        expect:
            obj.isZero(1) == true;
    }
}
