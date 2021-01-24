package java3.lesson3.homework;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class FileLogger
{
    private static final String LOG_DIR = "./";

    private final String nickname;
    private final String fileName;

    public FileLogger(String nickname)
    {
        this.nickname = nickname;

        this.fileName = LOG_DIR + String.format("history_%s.txt", nickname.replaceAll("[^a-zA-Z0-9\\.\\-]", "_"));;
    }

    public synchronized void addLog(String message)
    {
        try (FileWriter fileWriter = new FileWriter(fileName, Charset.forName("utf-8"), true))
        {
            fileWriter.append(message + System.lineSeparator());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized String getLastLines(int lineCount)
    {
        LinkedList<String> lines = new LinkedList<>();
        String fileLine = null;

        try (
            FileReader fileReader = new FileReader(fileName, Charset.forName("utf-8"));
            BufferedReader reader = new BufferedReader(fileReader))
        {
            while ((fileLine = reader.readLine()) != null)
            {
                lines.add(fileLine);

                if (lines.size() > lineCount)
                {
                    lines.remove(0);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            String ln = System.lineSeparator();

            for (String line : lines)
            {
                stringBuilder.append(line + ln);
            }

            return stringBuilder.toString();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return "";
    }
}
