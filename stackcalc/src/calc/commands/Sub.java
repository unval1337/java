package calc.commands;

import java.util.EmptyStackException;

public class Sub implements Command{

    @Override
    public void execute(Context context, String[] args)
    {
        if(context.getStackSize() < 2) throw new EmptyStackException();

        double n1 = context.pop();
        double n2 = context.pop();

        context.push(n1 - n2);
    }
}
