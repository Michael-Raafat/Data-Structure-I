package eg.edu.alexu.csd.datastructure.calculator.cs59;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 * @author Michael.
 *
 */

public class MyCalculator implements ICalculator {
    @Override
    public final int add(final int x, final int y) {
        return x + y;
    }
    @Override
    public final float divide(final int x, final int y) {
        return (float) x / y;
    }

}
