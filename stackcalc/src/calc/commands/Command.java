package calc.commands;

import calc.exceptions.CalcException;

public interface Command
{
    void execute(Context context, String[] args) throws CalcException;
}
