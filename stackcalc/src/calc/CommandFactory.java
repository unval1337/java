package calc;

import calc.commands.Command;
import calc.exceptions.CalcException;
import calc.exceptions.ExecuteNonexistentCommandException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandFactory {
    private static volatile CommandFactory instance;
    private static Logger logger = Logger.getLogger(CommandFactory.class.getName());
    Properties prop;

    private CommandFactory() throws IOException
    {
        try
        {
            logger.log(Level.INFO, "Got command properties");
            prop = new Properties();
            prop.load(new FileInputStream("src/calc/commands.properties"));
        }
        catch (Exception e)
        {
            logger.log(Level.WARNING, "Property exception: " + e);
            throw e;
        }

    }

    public static CommandFactory getInstance() throws IOException
    {
        if(instance == null)
            synchronized (CommandFactory.class)
            {
                if(instance == null)
                    logger.log(Level.INFO, "Got instance of CommandFactory");
                    instance = new CommandFactory();
            }
        return instance;
    }

    public Command addCommand(String commandName) throws CalcException
    {
        Command command = null;

        try
        {
            logger.log(Level.INFO, "Added command " + commandName);
            String className = prop.getProperty(commandName);
            if(className == null) return null;

            command = (Command) Class.forName(className).getDeclaredConstructor().newInstance();
        }
        catch (Exception e)
        {
            logger.log(Level.WARNING, "Exception of adding command " + commandName + ": " + e);
        }

        return command;
    }
}
