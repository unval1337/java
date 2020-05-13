package calc.commands;

import calc.exceptions.CalcException;
import calc.exceptions.InvalidVariableNameException;
import calc.exceptions.WrongQuantityOfArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Push implements Command
{
    private final static Logger logger = Logger.getLogger(Push.class.getName());

    @Override
    public void execute(Context context, String[] args) throws CalcException
    {
        if (args == null || args.length != 1) throw new WrongQuantityOfArgumentsException("Push: wrong quantity of arguments");

        if(Character.isDigit(args[0].charAt(0)))
        {
            context.push(Double.valueOf(args[0]));
        }
        else
        {
            Double val = context.getVariable(args[0]);
            if(val == null) throw new InvalidVariableNameException("Push: invalid name of variable in table");
            else
            {
                context.push(val);
            }
        }

        logger.log(Level.INFO, "Did operation " + this.getClass().getName());
    }
}
