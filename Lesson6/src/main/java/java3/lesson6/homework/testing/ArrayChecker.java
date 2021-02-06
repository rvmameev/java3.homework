package java3.lesson6.homework.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayChecker
{
    private ArrayChecker()
    {
    }

    public static int[] getArrayAfter(int[] arr, int value)
    {
        List<Integer> result = new ArrayList<>();

        int i = arr.length - 1;

        for (; i >= 0; i--)
        {
            if (arr[i] == value)
            {
                break;
            }

            result.add(arr[i]);
        }

        if (i < 0)
        {
            throw new RuntimeException("Array does not contains value " + value);
        }

        Collections.reverse(result);

        return  result.stream().mapToInt(x -> x).toArray();
    }

    public static boolean hasValues_1_or_4(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 1 || arr[i] == 4)
            {
                return true;
            }
        }

        return false;
    }
}
