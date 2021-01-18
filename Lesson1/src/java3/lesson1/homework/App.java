package java3.lesson1.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class App
{
    public static void main(String[] args)
    {
        // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
        System.out.println("Swap two elements of array:");
        Integer[] array = {1, 2, 3};
        System.out.println(Arrays.toString(array));

        swapElements(array, 1, 2);
        System.out.println(Arrays.toString(array));

        // 2. Написать метод, который преобразует массив в ArrayList
        System.out.println("\nArray to ArrayList:");
        ArrayList<Integer> list = toArrayList(array);
        System.out.println(list);

        // 3. Большая задача. Фрукты и коробки.
        Box<Apple> appleBox = new Box<>(Apple.class);
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println("\nApple box: " + appleBox);
        System.out.println("Weight: " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>(Orange.class);
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println("Orange box: " + orangeBox);
        System.out.println("Weight: " + orangeBox.getWeight());

        System.out.println("The boxes are equals: " + appleBox.Compare(orangeBox));

        System.out.println("Added an apple in apple box");
        appleBox.add(new Apple());

        System.out.println("The boxes are equals: " + orangeBox.Compare(appleBox));

        Box<Apple> appleAnotherBox = new Box<>(Apple.class);
        appleAnotherBox.add(new Apple());

        System.out.println("\nApple box: " + appleBox);
        System.out.println("Another apple box: " + appleAnotherBox);

        System.out.println("Moved apples to another box");
        appleBox.moveTo(appleAnotherBox);
        System.out.println("Apple box: " + appleBox);
        System.out.println("Another apple box: " + appleAnotherBox);

    }

    private static <T> void swapElements(T[] array, int index1, int index2)
    {
        if (array == null)
        {
            throw new NullPointerException("array must not be null");
        }

        if (index1 < 0 || index1 >= array.length)
        {
            throw new IllegalArgumentException("index1");
        }

        if (index2 < 0 || index2 >= array.length)
        {
            throw new IllegalArgumentException("index2");
        }

        T value = array[index2];
        array[index2] = array[index1];
        array[index1] = value;
    }

    private static <T> ArrayList<T> toArrayList(T[] array)
    {
        if (array == null)
        {
            throw new NullPointerException("array must not be null");
        }

        ArrayList<T> list = new ArrayList<>(array.length);

        for (int i = 0; i < array.length; i++)
        {
            list.add(array[i]);
        }

        return list;
    }
}
