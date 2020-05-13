import calc.commands.Context;
import calc.commands.Sum;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Sum sum = new Sum();

        context.push(2.0);
        context.push(10.0);
        sum.execute(context, new String[0]);

        assertEquals(context.peek(), 12.0, 0.00000001);
    }
}
