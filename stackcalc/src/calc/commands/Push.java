package calc.commands;

public class Push implements Command{

    @Override
    public void execute(Context context, String[] args)
    {

        if(Character.isDigit(args[0].charAt(0)))
        {
            context.push(Double.valueOf(args[0]));
        }
        else
        {
            Double val = context.getVariable(args[0]);
            if(val == null) throw new IllegalArgumentException();
            else
            {
                context.push(val);
            }
        }
    }
}
