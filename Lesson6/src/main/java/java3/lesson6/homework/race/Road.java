package java3.lesson6.homework.race;

import org.apache.log4j.Logger;

public class Road extends Stage
{
    private final static Logger logger = Logger.getLogger(Road.class);

    public Road(int length)
    {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c)
    {
        try
        {
            logger.trace(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            logger.trace(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e)
        {
            logger.error("Interrupted exception", e);
        }
    }
}