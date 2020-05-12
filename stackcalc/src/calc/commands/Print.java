package calc.commands;

public class Print implements Command{

    @Override
    public void execute(Context context, String[] args)
    {
        System.out.format("Last number: %fl\n", context.peek());

    }
}
