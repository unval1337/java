package calc.commands;


public interface Command
{
    void execute(Context context, String[] args);
}
