package java3.lesson4.homework;

public class RepitPrinter
{
    private final char[] letters;
    private final int printCount;
    private final Object locker = new Object();
    private int currentIndex = 0;

    public RepitPrinter(char[] letters, int printCount)
    {
        this.letters = letters;
        this.printCount = printCount;
    }

    void print(int index)
    {
        try
        {
            synchronized (locker)
            {
                for (int i = 0; i < printCount; i++)
                {
                    while (currentIndex != index)
                    {
                        locker.wait();
                    }

                    System.out.println(letters[index]);

                    currentIndex = (currentIndex + 1) % letters.length;

                    locker.notifyAll();
                }
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
