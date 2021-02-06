package java3.lesson6.homework.race;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage
{
    private final static Logger logger = Logger.getLogger(Tunnel.class);

    private Semaphore semaphore;

    public Tunnel(int maxCars)
    {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(maxCars);
    }

    @Override
    public void go(Car c)
    {
        try
        {
            try
            {
                logger.trace(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                logger.trace(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e)
            {
                logger.error("Interrupted exception", e);
            } finally
            {
                logger.trace(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e)
        {
            logger.error("Tunnel exception", e);
        }
    }
}