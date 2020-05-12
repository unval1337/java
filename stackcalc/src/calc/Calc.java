package calc;

import calc.commands.Command;
import calc.commands.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calc
{
    public void execute(InputStream in)
    {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        Command command = null;
        String[] strs;
        Context context = new Context();
        try{
            while((str = br.readLine()) != null)
            {
//                System.out.println(str);
                if(str.charAt(0) == '#') continue;

                strs = str.split(" ");
                String commandName = strs[0];
                String[] args = new String[strs.length - 1];
                System.arraycopy(strs, 1, args, 0, strs.length - 1);

                command = CommandFactory.getInstance().addCommand(commandName);
                command.execute(context, args);

            }
        }
        catch (IOException e)
        {
            System.out.format("Exception: %s\n", e);
        }

    }
}
