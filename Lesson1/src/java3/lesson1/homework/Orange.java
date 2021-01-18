package java3.lesson1.homework;

public class Orange extends Fruit
{
    private static final float WEIGHT = 1.5f;

    public static float getWeight()
    {
        return WEIGHT;
    }

    @Override
    public String toString()
    {
        return Orange.class.getSimpleName();
    }
}
