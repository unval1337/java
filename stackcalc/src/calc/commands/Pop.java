package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pop implements Command
{
    private final static Logger logger = Logger.getLogger(Pop.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if (args == null || args.length != 0) throw new WrongQuantityOfArgumentsException("Pop: wrong quantity of arguments");
        context.pop();
        logger.log(Level.INFO, "Did operation " + this.getClass().getName());
    }
}
