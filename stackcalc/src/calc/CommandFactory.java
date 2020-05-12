package calc;

import calc.commands.Command;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommandFactory {
    private static volatile CommandFactory instance;
    Properties prop;

    private CommandFactory() throws IOException
    {
        try
        {
            prop = new Properties();
            prop.load(new FileInputStream("src/calc/commands.properties"));
        }
        catch (Exception e)
        {
            System.out.format("Property error: %s\n", e);
            throw e;
        }

    }

    public static CommandFactory getInstance() throws IOException
    {
        if(instance == null)
            synchronized (CommandFactory.class)
            {
                if(instance == null)
                    instance = new CommandFactory();
            }
        return instance;
    }

    public Command addCommand(String commandName)
    {
        Command command = null;
        try
        {
            command = (Command) Class.forName(prop.getProperty(commandName)).getDeclaredConstructor().newInstance();
        }
        catch (Exception e)
        {
            System.out.format("%s\n", e);
        }

        return command;
    }
}
