package java3.lesson1.homework;

import java.util.*;

public class Box<T extends Fruit>
{
    private final List<T> store;
    private final Class<T> clazz;

    public Box(Class<T> clazz)
    {
        this.clazz = clazz;
        this.store = new ArrayList<>();
    }

    public boolean add(T value)
    {
        return store.add(value);
    }

    public float getWeight()
    {
        float weight = 0;

        if (Apple.class.isAssignableFrom(clazz))
        {
            weight = Apple.getWeight();

        } else if (Orange.class.isAssignableFrom(clazz))
        {
            weight = Orange.getWeight();
        }
        else
        {
            throw new RuntimeException(String.format("Weight not defined (%s)", clazz.getName()));
        }

        return weight * store.size();
    }

    public boolean Compare(Box<? extends Fruit> box)
    {
        return getWeight() == box.getWeight();
    }

    public void moveTo(Box<T> box)
    {
        box.store.addAll(store);

        store.clear();
    }

    @Override
    public String toString()
    {
        return clazz.getSimpleName() + " box " + store;
    }
}
