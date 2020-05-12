package calc.commands;

import java.util.Stack;
import java.util.HashMap;

public class Context {
    private Stack<Double> stack = new Stack<Double>();
    private HashMap<String, Double> varsTable = new HashMap<String, Double>();

    public void push(Double val)
    {
        stack.push(val);
    }

    public Double pop()
    {
        return stack.pop();
    }

    public int getStackSize()
    {
        return stack.size();
    }

    public Double getVariable(String key)
    {
        return varsTable.get(key);
    }

    public void setVariable(String key, Double val)
    {
        varsTable.put(key, val);
    }

    public Double peek()
    {
        return stack.peek();
    }
}
