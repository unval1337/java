package calc.commands;

import java.util.EmptyStackException;

public class Sqrt implements Command{

    @Override
    public void execute(Context context, String[] args)
    {
        if(context.getStackSize() < 1) throw new EmptyStackException();

        double n1 = context.pop();

        context.push(Math.sqrt(n1));
    }
}
