package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Define implements Command
{
    private final static Logger logger = Logger.getLogger(Define.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if(args != null && args.length == 2 && !Character.isDigit(args[0].charAt(0)) && Character.isDigit(args[1].charAt(0)))
        {
            context.setVariable(args[0], Double.valueOf(args[1]));
            logger.log(Level.INFO, "Did operation " + this.getClass().getName());
        }
        else
        {
            throw new WrongQuantityOfArgumentsException("Define: Wrong quantity of arguments");
        }
    }
}
