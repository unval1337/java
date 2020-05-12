package calc.commands;

public class Pop implements Command{

    @Override
    public void execute(Context context, String[] args)
    {
        context.pop();
    }
}
