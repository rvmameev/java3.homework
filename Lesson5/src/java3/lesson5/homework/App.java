package java3.lesson5.homework;

import javax.sound.midi.Soundbank;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class App
{
    public static final int CARS_COUNT = 4;

    private static CountDownLatch startLocker = new CountDownLatch(CARS_COUNT);
    private static CountDownLatch finishLocker = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
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
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        finishLocker.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победитель: " + race.getWinner().getName());
    }
}
