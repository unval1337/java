import calc.commands.Context;
import calc.commands.Define;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefineTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Define define = new Define();

        String[] args = {"a", "2"};
        define.execute(context, args);

        assertEquals(context.getVariable("a"), 2.0, 0.00000001);

        args[0] = "b";
        args[1] = "3";
        define.execute(context, args);

        assertEquals(context.getVariable("b"), 3.0, 0.00000001);

    }
}
