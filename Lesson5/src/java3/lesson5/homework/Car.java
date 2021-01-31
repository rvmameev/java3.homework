package java3.lesson5.homework;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable
{
    private static int CARS_COUNT;

    static
    {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private final CountDownLatch startLocker;
    private final CountDownLatch finishLocker;
    private String name;

    public String getName()
    {
        return name;
    }

    public int getSpeed()
    {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch startLocker, CountDownLatch finishLocker)
    {
        this.race = race;
        this.speed = speed;
        this.startLocker = startLocker;
        this.finishLocker = finishLocker;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            startLocker.countDown();
            startLocker.await();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++)
        {
            race.getStages().get(i).go(this);
        }

        synchronized (race)
        {
            if (race.getWinner() == null)
            {
                race.setWinner(this);
            }
        }

        finishLocker.countDown();
    }
}