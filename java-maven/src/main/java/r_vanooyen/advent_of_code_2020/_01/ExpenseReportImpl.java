package r_vanooyen.advent_of_code_2020._01;

public class ExpenseReportImpl implements ExpenseReport {

    public static final int SUM_TARGET = 2020;

    @Override
    public long calcProduct(final Long... numbers) {
        final Long[] numbersCloned = numbers.clone();

        for (final Long numberA : numbers) {
            for (final Long numberB : numbersCloned) {
                if ((numberA + numberB) == SUM_TARGET) {
                    return numberA * numberB;
                }
            }
        }
        throw new IllegalArgumentException("no 2 numbers of parammeter numbers sum up to " + SUM_TARGET);
    }
}
