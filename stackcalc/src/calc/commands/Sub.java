package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.StackQuantityException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sub implements Command
{
    private final static Logger logger = Logger.getLogger(Sub.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if (args == null || args.length != 0) throw new WrongQuantityOfArgumentsException("Sub: wrong quantity of arguments");
        if(context.getStackSize() < 2) throw new StackQuantityException("Sub: wrong quantity of stack arguments");

        double n1 = context.pop();
        double n2 = context.pop();

        context.push(n1 - n2);
        logger.log(Level.INFO, "Did operation " + this.getClass().getName());
    }
}
