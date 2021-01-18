package java3.lesson1.homework;

public class Apple extends Fruit
{
    private static final float WEIGHT = 1.0f;

    public static float getWeight()
    {
        return WEIGHT;
    }

    @Override
    public String toString()
    {
        return Apple.class.getSimpleName();
    }
}
