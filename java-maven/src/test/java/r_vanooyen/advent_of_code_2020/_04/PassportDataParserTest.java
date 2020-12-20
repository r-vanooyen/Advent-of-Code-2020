package r_vanooyen.advent_of_code_2020._04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PassportDataParserTest {

    private PassportDataParser serviceUnderTest;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new PassportDataParser();
    }

    @Test
    void parseInput_whenGivenNull_shouldThrowAnException() {
        assertThatCode(() -> serviceUnderTest.parseInput((String[]) null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseInput_whenGivenAValidPassport_shouldBuildValidPassports() {
        final Collection<Passport> passports = serviceUnderTest.parseInput("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                                                                           "byr:1937 iyr:2017 cid:147 hgt:183cm");

        assertThat(passports).hasSize(1)
                             .allMatch(Passport::isValid);
    }

    @Test
    void parseInput_whenGivenANonValidPassport_shouldBuildInvalidPassports() {
        final Collection<Passport> passports = serviceUnderTest.parseInput(
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884", "hcl:#cfa07d byr:1929");

        assertThat(passports).hasSize(1)
                             .noneMatch(Passport::isValid);
    }

    @Test
    void parseInput_whenGivenTestInput_shouldBuild2ValidPassports() throws URISyntaxException, IOException {
        final List<String> passportData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("04/testInput.txt").toURI()));

        final Collection<Passport> passports = serviceUnderTest.parseInput(passportData);

        assertThat(passports.stream().filter(Passport::isValid).collect(Collectors.toList())).hasSize(2);
    }

    @Test
    void parseInput_whenGivenOnlyValidInput_shouldBuild4ValidPassports() throws URISyntaxException, IOException {
        final List<String> passportData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("04/someValidPassports.txt").toURI()));

        final Collection<Passport> passports = serviceUnderTest.parseInput(passportData);

        assertThat(passports.stream().filter(Passport::isValid).collect(Collectors.toList())).hasSize(4);
    }

    @Test
    void parseInput_whenGivenInvalidInput_shouldBuildNoValidPassports() throws URISyntaxException, IOException {
        final List<String> passportData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("04/someInvalidPassports.txt").toURI()));

        final Collection<Passport> passports = serviceUnderTest.parseInput(passportData);

        assertThat(passports.stream().filter(Passport::isValid).collect(Collectors.toList())).hasSize(0);
    }

    @Test
    void parseInput_whenGivenChallengeInput_shouldNotThrowAnyExceptions() throws URISyntaxException, IOException {
        final List<String> passportData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("04/challengeInput.txt").toURI()));

        final Collection<Passport> passports = new ArrayList<>();
        assertThatCode(() -> passports.addAll(serviceUnderTest.parseInput(passportData))).doesNotThrowAnyException();

        System.out.println("amount valid passports=" + passports.stream().filter(Passport::isValid).count());
    }
}
