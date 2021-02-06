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
public class ArrayChecker_getArrayAfter_Test
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameter(0)
    public int value;

    @Parameterized.Parameter(1)
    public int[] arr;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameter(3)
    public Class<? extends RuntimeException> expectedException;

    @Parameterized.Parameters
    public static Collection<Object[]> cases()
    {
        return Arrays.asList(new Object[][]{
            {4, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}, null},
            {4, new int[]{1, 2, 3, 4, 4}, new int[]{}, null},
            {4, new int[]{1, 2, 3}, new int[]{}, RuntimeException.class}
        });
    }

    @Test
    public void getArrayAfter() throws RuntimeException
    {
        if (expectedException != null)
        {
            thrown.expect(expectedException);
        }

        Assert.assertArrayEquals(expected, ArrayChecker.getArrayAfter(arr, value));
    }
}
