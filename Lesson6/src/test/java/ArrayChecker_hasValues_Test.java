import java3.lesson6.homework.testing.ArrayChecker;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ArrayChecker_hasValues_Test
{
    @Parameterized.Parameter(0)
    public int[] arr;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> cases()
    {
        return Arrays.asList(new Object[][]{
            {new int[]{}, false},
            {new int[]{1, 2, 3, 4}, true},
            {new int[]{1, 2, 3}, true},
            {new int[]{2, 3, 4}, true},
            {new int[]{2, 2, 3}, false},
        });
    }

    @Test
    public void getArrayAfter()
    {
        Assert.assertEquals(expected, ArrayChecker.hasValues_1_or_4(arr));
    }
}
