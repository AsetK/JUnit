package com.epam.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Запуск нескольких тестовых классов
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class})
public class MyTestSuite {
}
