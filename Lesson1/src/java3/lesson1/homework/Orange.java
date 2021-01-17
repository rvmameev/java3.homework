package java3.lesson1.homework;

public class Orange extends Fruit
{
    private static final float weight = 1.5f;

    @Override
    public float getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Orange";
    }
}
