package java3.lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Race
{
    private ArrayList<Stage> stages;
    private Car winner;

    public ArrayList<Stage> getStages()
    {
        return stages;
    }

    public Race(Stage... stages)
    {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void setWinner(Car winner)
    {
        this.winner = winner;
    }

    public Car getWinner()
    {
        return winner;
    }
}