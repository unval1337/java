package calc.commands;

public class Define implements Command
{
    @Override
    public void execute(Context context, String[] args)
    {

        if(!Character.isDigit(args[0].charAt(0)) && Character.isDigit(args[1].charAt(0)))
        {
            context.setVariable(args[0], Double.valueOf(args[1]));
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
