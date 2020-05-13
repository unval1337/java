import calc.commands.Context;
import calc.commands.Push;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PushTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Push push = new Push();

        String[] args = new String[1];
        args[0] = "5";

        push.execute(context, args);
        assertEquals(context.peek(), 5.0, 0.00000001);
    }
}
