package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.StackQuantityException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sqrt implements Command
{
    private final static Logger logger = Logger.getLogger(Sqrt.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if (args == null || args.length != 0) throw new WrongQuantityOfArgumentsException("Sqrt: wrong quantity of arguments");
        if(context.getStackSize() < 1) throw new StackQuantityException("Sqrt: wrong quantity of stack arguments");

        double n1 = context.pop();

        context.push(Math.sqrt(n1));
        logger.log(Level.INFO, "Did operation " + this.getClass().getName());
    }
}
