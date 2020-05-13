import calc.commands.Context;
import calc.commands.Pop;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PopTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Pop pop = new Pop();

        context.push(2.0);
        context.push(10.0);
        pop.execute(context, new String[0]);

        assertEquals(context.peek(), 2.0, 0.00000001);
    }
}
