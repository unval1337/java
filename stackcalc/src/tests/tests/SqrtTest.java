import calc.commands.Context;
import calc.commands.Sqrt;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Sqrt sqrt = new Sqrt();

        context.push(25.0);
        sqrt.execute(context, new String[0]);

        assertEquals(context.peek(), 5.0, 0.00000001);
    }
}
