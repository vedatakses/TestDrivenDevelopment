import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearSpec
{
    public static class A_year_is_a_leap_year
    {
        @Test
        public void if_it_is_divisible_by_4_but_not_by_100()
        {
            assertTrue(Year.isLeap(2016));
        }
        @Test
        public void if_it_is_divisible_by_400()
        {
            assertTrue(Year.isLeap(2000));
        }
    }
    public static class A_year_is_not_a_leap_year
    {
        @Test
        public void if_it_is_not_divisible_by_4()
        {
            assertFalse(Year.isLeap(2017));
        }
        @Test
        public void if_it_is_divisible_by_100_but_not_by_400()
        {
            assertFalse(Year.isLeap(1900));
        }
    }
    public static class A_year_is_not_supported
    {
        @Test(expected=IllegalArgumentException.class)
        public void if_it_is_0()
        {
            Year.isLeap(0);
        }
        @Test(expected=IllegalArgumentException.class)
        public void if_it_is_negative()
        {
            Year.isLeap(-1);
        }
    }
}
