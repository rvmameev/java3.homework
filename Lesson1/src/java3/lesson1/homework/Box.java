package java3.lesson1.homework;

import java.util.*;

public class Box<T extends Fruit>
{
    private final List<T> store;

    public Box()
    {
        this.store = new ArrayList<>();
    }

    public boolean add(T value)
    {
        return store.add(value);
    }

    public float getWeight()
    {
        if (store.isEmpty())
        {
            return 0;
        }

        return store.size() * store.get(0).getWeight();
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
        return "Box " + store;
    }
}
