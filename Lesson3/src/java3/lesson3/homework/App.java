package java3.lesson3.homework;

import javax.swing.*;
import java.util.Random;

public class App
{
    public static void main(String[] args)
    {
        // 1. Добавить в сетевой чат запись локальной истории в текстовый файл на клиенте.

        String nick1 = "nick1#1.2-3";

        FileLogger logger = new FileLogger(nick1);

        logger.addLog("nick2 -> message2");
        logger.addLog("nick3 -> message3");

        // 2. После загрузки клиента показывать ему последние 100 строк чата

        Random random = new Random();
        logger = new FileLogger("nick");

        for (int i = 1; i <= 1000; i++)
        {
            String message = String.format("nick%d -> message%d", random.nextInt(10) + 1, i);

            logger.addLog(message);
        }

        System.out.println(logger.getLastLines(100));
    }
}
