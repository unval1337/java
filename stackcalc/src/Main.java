import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import calc.Calc;


public class Main
{
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)
    {
        LogManager logManager = LogManager.getLogManager();
        try
        {
            logManager.readConfiguration(new FileInputStream("src/calc/logger.properties"));
        }
        catch (IOException e)
        {
            System.out.format("Logger error: %s\nExit\n", e);
            return;
        }


        InputStream in;
        if(args.length == 0)
        {
            logger.log(Level.INFO, "Selected System.in stream");
            in = System.in;
        }
        else
        {
            try
            {
                logger.log(Level.INFO, "Selected " + args[0]);
                in = new FileInputStream(args[0]);
            }
            catch (Exception e)
            {
                logger.log(Level.WARNING, "Exception: " + e);
                return;
            }

        }

        Calc calc = new Calc();
        calc.execute(in);

        logger.log(Level.INFO, "Successful exit");
    }
}
