package r_vanooyen.advent_of_code_2020._02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class DatabasePasswordCheckerTest {

    private DatabasePasswordChecker serviceUnderTest;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new DatabasePasswordCheckerImpl();
    }

    @Test
    void lookupAmountOfValidPasswords_whenGivenAPasswordWithPoliciesIsGiven_shouldReturnOne() {
        DatabasePasswordEntry databasePasswordEntry = new DatabasePasswordEntry("1-2 y: myValidPassowrd");

        final long amountOfValidPasswords = serviceUnderTest.lookupAmountOfValidPasswords(databasePasswordEntry);

        assertThat(amountOfValidPasswords).isEqualTo(1);
    }

    @Test
    void calcProduct_whenGivenTestInput_ShouldReturn514579() throws IOException, URISyntaxException {
        final List<String> dbInputs = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("02/testInput.txt").toURI()));
        final long result = serviceUnderTest.lookupAmountOfValidPasswords(dbInputs.toArray(new String[0]));

        assertThat(result).isEqualTo(2);
    }

    @Test
    void calcProduct_whenGivenChallengeInput_ShouldNotThrowAnyExceptions() throws IOException, URISyntaxException {
        final List<String> dbInputs = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("02/challengeInput.txt").toURI()));

        Long[] result = new Long[1];
        assertThatCode(() -> result[0] = serviceUnderTest.lookupAmountOfValidPasswords(dbInputs.toArray(new String[0])))
                .doesNotThrowAnyException();

        System.out.println("Amount of valid passwords=" + result[0]);
    }
}
