package calc;

import calc.commands.Command;
import calc.commands.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calc
{
    private static Logger logger = Logger.getLogger(Calc.class.getName());

    public void execute(InputStream in)
    {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        logger.log(Level.INFO, "Created BufferedReader");

        Command command = null;
        String[] strs;
        Context context = new Context();
        try{
            while((str = br.readLine()) != null)
            {
                if(str.charAt(0) == '#')
                {
                    logger.log(Level.INFO, "Found comment");
                    continue;
                }

                strs = str.split(" ");
                String commandName = strs[0];
                String[] args = new String[strs.length - 1];
                System.arraycopy(strs, 1, args, 0, strs.length - 1);

                command = CommandFactory.getInstance().addCommand(commandName);
                command.execute(context, args);

            }
        }
        catch (Exception e)
        {
            logger.log(Level.WARNING, "Exception: " + e);
        }

    }
}
