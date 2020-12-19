package r_vanooyen.advent_of_code_2020._01;

import java.util.Arrays;

public class ExpenseReportImpl implements ExpenseReport {

    public static final int SUM_TARGET = 2020;

    @Override
    public long calcProduct(final Long... numbers) {
        for (final Long numberA : numbers) {
            for (final Long numberB : numbers) {
                if (sum(numberA, numberB) == SUM_TARGET) {
                    return product(numberA, numberB);
                }
            }
        }
        throw new IllegalArgumentException("no 2 numbers of parammeter numbers sum up to " + SUM_TARGET);
    }

    @Override
    public long calcProductOf3Numbers(final Long... numbers) {
        for (final Long numberA : numbers) {
            for (final Long numberB : numbers) {
                for (final Long numberC : numbers) {
                    if (sum(numberA, numberB, numberC) == SUM_TARGET) {
                        return product(numberA, numberB, numberC);
                    }
                }
            }
        }
        throw new IllegalArgumentException("no 3 numbers of parammeter numbers sum up to " + SUM_TARGET);
    }

    private Long sum(Long... numbers) {
        return Arrays.stream(numbers).mapToLong(value -> value).sum();
    }

    private Long product(Long... numbers) {
        return Arrays.stream(numbers).mapToLong(value -> value).reduce(1, (left, right) -> left * right);
    }
}
