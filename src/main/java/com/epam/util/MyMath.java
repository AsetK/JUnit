package com.epam.util;

public class MyMath {

    private static String st;
    private CalculatorService service;

    public MyMath (CalculatorService service){
        this.service = service;
    }

    public static int add(int a, int b){return a+b;}
    public static int sub(int a, int b){return a-b;}
    public static int div(int a, int b){return a/b;}
    public static boolean isZero(int a){return a==0;}

    public int mult(int a, int b){return service.mult(a, b);}


}
