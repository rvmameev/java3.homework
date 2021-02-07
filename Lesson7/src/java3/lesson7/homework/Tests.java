package java3.lesson7.homework;

import java3.lesson7.homework.annotation.*;

public class Tests
{
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before suite");
    }

    @Test(order = 1)
    public void test1()
    {
        System.out.println("test1");
    }

    @Test(order = 2)
    public void test2()
    {
        System.out.println("test2");
    }

    @Test(order = 3)
    public void test4()
    {
        System.out.println("test4");
    }

    @Test(order = 3)
    public void test3()
    {
        System.out.println("test3");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After suite");
    }
}
