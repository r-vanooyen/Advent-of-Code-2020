package r_vanooyen.advent_of_code_2020._07;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BagRuleTest {

    @Test
    void bagColorWhichCanContain_whenGivenASingleRule_shouldReturnTheRightColor() {
        final BagRule bagRule = new BagRule("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");

        final Collection<String> olive = bagRule.bagColorWhichCanContain("olive");

        assertThat(olive).contains("shiny gold");
    }

    @Test
    void bagColorWhichCanContain_whenGivenASingleRuleWithMultipleWordColor_shouldReturnTheRightColor() {
        final BagRule bagRule = new BagRule("bright white bags contain 1 shiny gold bag.");

        final Collection<String> olive = bagRule.bagColorWhichCanContain("shiny gold");

        assertThat(olive).contains("bright white");
    }

    @Test
    void bagColorWhichCanContain_whenGivenTestInputWithMultipleWordColor_shouldReturnTheRightColor()
            throws URISyntaxException, IOException {

        final String rulesString = Files.lines(Paths.get(ClassLoader.getSystemResource("07/testInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule bagRule = new BagRule(rulesString);

        final Collection<String> olive = bagRule.bagColorWhichCanContain("shiny gold");

        assertThat(olive).contains("bright white");
    }

    @Test
    void bagColorWhichCanContain_whenGivenTestInput_shouldFind4BagsWhichCanContainGoldBag()
            throws URISyntaxException, IOException {
        final String rulesString = Files.lines(Paths.get(ClassLoader.getSystemResource("07/testInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule rules = new BagRule(rulesString);

        final Collection<String> shiny_gold = rules.allBagColorsWhichCanContain("shiny gold");

        assertThat(shiny_gold).hasSize(4);
    }

    @Test
    void bagColorWhichCanContain_whenGivenChallengeInput_shouldNotReturnAnyExceptionsAndLogResult()
            throws URISyntaxException, IOException {
        final String rulesString = Files.lines(
                Paths.get(ClassLoader.getSystemResource("07/challengeInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule rules = new BagRule(rulesString);
        final Collection<String> shiny_gold = new ArrayList<>();
        assertThatCode(() -> shiny_gold.addAll(rules.allBagColorsWhichCanContain("shiny gold")))
                .doesNotThrowAnyException();

        System.out.println(shiny_gold.size());
    }

    @Test
    void bagColorsWhichCanBeWithin_whenGivenASingleRule_shouldReturnTheRightColors() {
        final BagRule bagRule = new BagRule("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");

        final Collection<String> shiny_gold = bagRule.bagColorsWhichCanBeWithin("shiny gold");

        assertThat(shiny_gold).hasSize(3)
                              .contains("dark olive")
                              .contains("vibrant plum");
    }

    @Test
    void bagColorsWhichCanBeWithin_whenGivenTestInputWithMultipleWordColor_shouldReturnTheRightColors()
            throws URISyntaxException, IOException {

        final String rulesString = Files.lines(Paths.get(ClassLoader.getSystemResource("07/testInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule bagRule = new BagRule(rulesString);

        final Collection<String> vibrant_plum = bagRule.bagColorsWhichCanBeWithin("vibrant plum");

        assertThat(vibrant_plum).hasSize(11);
    }

    @Test
    void allBagColorsWhichCanBeWithin_whenGivenTestInputWithMultipleWordColor_shouldReturnTheRightColorsRecursive()
            throws URISyntaxException, IOException {

        final String rulesString = Files.lines(Paths.get(ClassLoader.getSystemResource("07/testInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule bagRule = new BagRule(rulesString);

        final Collection<String> shiny_gold = bagRule.allBagColorsWhichCanBeWithin("shiny gold");

        assertThat(shiny_gold).hasSize(32);
    }

    @Test
    void allBagColorsWhichCanBeWithin_whenGivenChallengeInput_shouldNotReturnAnyExceptionsAndLogResult()
            throws URISyntaxException, IOException {
        final String rulesString = Files.lines(
                Paths.get(ClassLoader.getSystemResource("07/challengeInput.txt").toURI()))
                                        .collect(Collectors.joining("\n"));

        final BagRule rules = new BagRule(rulesString);
        final Collection<String> shiny_gold = new ArrayList<>();
        assertThatCode(() -> shiny_gold.addAll(rules.allBagColorsWhichCanBeWithin("shiny gold")))
                .doesNotThrowAnyException();

        System.out.println(shiny_gold.size());
    }
}
