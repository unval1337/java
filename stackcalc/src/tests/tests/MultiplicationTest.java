import calc.commands.Context;
import calc.commands.Multiplication;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Multiplication multiplication = new Multiplication();

        context.push(2.0);
        context.push(10.0);
        multiplication.execute(context, new String[0]);

        assertEquals(context.peek(), 20.0, 0.00000001);
    }
}
