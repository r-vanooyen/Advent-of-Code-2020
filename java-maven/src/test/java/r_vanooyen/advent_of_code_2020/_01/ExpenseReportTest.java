package r_vanooyen.advent_of_code_2020._01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ExpenseReportTest {

    private ExpenseReport serviceUnderTest;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new ExpenseReportImpl();
    }

    @Test
    void calcProduct_whenGivenValidTwoNumbers_ShouldReturnProduct() {
        final long l = serviceUnderTest.calcProduct(2000L, 20L);

        assertThat(l).isEqualTo(40000);
    }

    @Test
    void calcProduct_whenGivenTestInput_ShouldReturn514579() throws IOException, URISyntaxException {
        Long[] numbers = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("01/testInput.txt").toURI()))
                              .stream()
                              .map(Long::valueOf)
                              .collect(Collectors.toList()).toArray(new Long[0]);

        final long result = serviceUnderTest.calcProduct(numbers);

        assertThat(result).isEqualTo(514579);
    }

    @Test
    void calcProduct_whenGivenChallengeInput_ShouldOutputResult() throws IOException, URISyntaxException {
        Long[] numbers = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("01/challengeInput.txt").toURI()))
                              .stream()
                              .map(Long::valueOf)
                              .collect(Collectors.toList()).toArray(new Long[0]);

        final Long[] result = new Long[1];
        assertThatCode(() -> result[0] = serviceUnderTest.calcProduct(numbers))
                .doesNotThrowAnyException();

        System.out.print("Result of 01/challengeInput.txt is=" + result[0]);
    }
}
