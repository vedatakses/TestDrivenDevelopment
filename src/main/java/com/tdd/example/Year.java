import static java.lang.Math.*;

public class Year
{
    public static boolean isLeap(int year)
    {
        try
        {
            return
                signum(1 / (year + abs(year))) +
                signum(year % 4) -
                signum(year % 100) +
                signum(year % 400) == 0;
        }
        catch (ArithmeticException divisionByZero)
        {
            throw new IllegalArgumentException();
        }
    }
}
