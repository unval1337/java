package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Command
{
    private final static Logger logger = Logger.getLogger(Print.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if (args == null || args.length != 0) throw new WrongQuantityOfArgumentsException("Print: wrong quantity of arguments");
        System.out.format("Last number: %fl\n", context.peek());

        logger.log(Level.INFO, "Did operation " + this.getClass().getName());
    }
}
