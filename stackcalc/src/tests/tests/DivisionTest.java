import calc.commands.Context;
import calc.commands.Division;
import calc.exceptions.CalcException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisionTest {
    @Test
    public void execute() throws CalcException {
        Context context = new Context();
        Division division = new Division();

        context.push(2.0);
        context.push(10.0);
        division.execute(context, new String[0]);

        assertEquals(context.peek(), 5.0, 0.00000001);
    }
}
