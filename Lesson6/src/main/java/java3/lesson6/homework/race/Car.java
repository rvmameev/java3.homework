package java3.lesson6.homework.race;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable
{
    private final static Logger logger = Logger.getLogger(Car.class);

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
            logger.trace(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            logger.trace(this.name + " готов");

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