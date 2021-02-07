package java3.lesson7.homework;

import java3.lesson7.homework.annotation.AfterSuite;
import java3.lesson7.homework.annotation.BeforeSuite;
import java3.lesson7.homework.annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner
{
    private TestRunner()
    {
    }

    public static void start(Class clazz)
    {
        try
        {
            Constructor<?> ctor = clazz.getConstructor();

            Object instance = ctor.newInstance();

            runSingleAnnotationMethod(BeforeSuite.class, clazz, instance);

            runTestMethods(clazz, instance);

            runSingleAnnotationMethod(AfterSuite.class, clazz, instance);
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }


    private static void runTestMethods(Class clazz, Object instance) throws InvocationTargetException, IllegalAccessException
    {
        class OrderMethod
        {
            private final int order;
            private final Method method;

            public OrderMethod(int order, Method method)
            {
                this.order = order;
                this.method = method;
            }
        }

        List<OrderMethod> orderMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods())
        {
            if (method.isAnnotationPresent(Test.class))
            {
                Test testAnnotation = method.getAnnotation(Test.class);

                orderMethods.add(new OrderMethod(testAnnotation.order(), method));
            }
        }

        Collections.sort(orderMethods, Comparator.comparing(o -> o.order));

        for (OrderMethod orderMethod : orderMethods)
        {
            orderMethod.method.invoke(instance);
        }
    }

    private static void runSingleAnnotationMethod(Class annotation, Class<?> clazz, Object instance) throws InvocationTargetException, IllegalAccessException
    {
        List<Method> methods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods())
        {
            if (method.isAnnotationPresent(annotation))
            {
                methods.add(method);
            }
        }

        if (methods.size() > 1)
        {
            throw new RuntimeException(String.format("The number of annotations must be equal to one (%s)", annotation.getName()));
        }

        for (Method method : methods)
        {
            method.invoke(instance);
        }
    }
}
