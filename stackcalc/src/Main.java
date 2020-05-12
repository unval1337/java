import java.io.FileInputStream;
import java.io.InputStream;

import calc.Calc;

public class Main {

    public static void main(String[] args)
    {
        InputStream in;
        if(args.length == 0)
        {
            in = System.in;
        }
        else
        {
            try
            {
                in = new FileInputStream(args[0]);
            }
            catch (Exception e)
            {
                System.out.format("Exception: %s\n", e);
                return;
            }

        }

        Calc calc = new Calc();
        calc.execute(in);

    }
}
