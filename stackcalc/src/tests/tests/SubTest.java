import calc.commands.Context;
import calc.commands.Sub;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Sub sub = new Sub();

        context.push(2.0);
        context.push(10.0);
        sub.execute(context, new String[0]);

        assertEquals(context.peek(), 8.0, 0.00000001);
    }
}
