package java3.lesson6.homework.race;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class App
{
    final static Logger logger = Logger.getLogger(App.class);

    public static final int CARS_COUNT = 4;

    private static CountDownLatch startLocker = new CountDownLatch(CARS_COUNT);
    private static CountDownLatch finishLocker = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException
    {
        logger.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), startLocker, finishLocker);
        }
        for (int i = 0; i < cars.length; i++)
        {
            new Thread(cars[i]).start();
        }

        startLocker.await();
        logger.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        finishLocker.await();
        logger.info("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        logger.info("Победитель: " + race.getWinner().getName());
    }
}
