package r_vanooyen.advent_of_code_2020._06;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CustomsDeclarationTest {

    @Test
    void getQuestionsAnsweredWithTrue_whenGivenSomeAnswers_ShouldGetUniqueAnswered() {
        final CustomsDeclaration customsDeclarationAnswers = new CustomsDeclaration("aabbbbc\n");

        assertThat(customsDeclarationAnswers.getQuestionsAnsweredWithTrue()).hasSize(3);
    }

    @Test
    void getUniqueQuestionsAnsweredWithTrue_whenTestInput_ShouldGet11ExpectedAnswers()
            throws URISyntaxException, IOException {
        final List<String> customsDeclarationData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("06/testInput.txt").toURI()));

        final Collection<Group> customsDeclarationGroups = new ArrayList<>();

        Group currentWork = new Group();
        for (final String customsDeclaration : customsDeclarationData) {
            if ("".equals(customsDeclaration)) {
                customsDeclarationGroups.add(currentWork);
                currentWork = new Group();
            } else {
                currentWork.addCustomDeclaration(new CustomsDeclaration(customsDeclaration));
            }
        }
        customsDeclarationGroups.add(currentWork);

        final int sum = customsDeclarationGroups.stream().map(Group::getUniqueQuestionsAnsweredWithTrue)
                                                .mapToInt(Set::size)
                                                .sum();

        assertThat(sum).isEqualTo(11);
    }

    @Test
    void getUniqueQuestionsAnsweredWithTrue_whenChallengeInput_ShouldLogCountAnswers()
            throws URISyntaxException, IOException {
        final List<String> customsDeclarationData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("06/challengeInput.txt").toURI()));

        final Collection<Group> customsDeclarationGroups = new ArrayList<>();

        Group currentWork = new Group();
        for (final String customsDeclaration : customsDeclarationData) {
            if ("".equals(customsDeclaration)) {
                customsDeclarationGroups.add(currentWork);
                currentWork = new Group();
            } else {
                currentWork.addCustomDeclaration(new CustomsDeclaration(customsDeclaration));
            }
        }
        customsDeclarationGroups.add(currentWork);

        final int sum = customsDeclarationGroups.stream().map(Group::getUniqueQuestionsAnsweredWithTrue)
                                                .mapToInt(Set::size)
                                                .sum();

        System.out.println(sum);
    }

    @Test
    void getUnifiedQuestionsAnsweredWithTrue_whenTestInput_ShouldGet11ExpectedAnswers()
            throws URISyntaxException, IOException {
        final List<String> customsDeclarationData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("06/testInput.txt").toURI()));

        final Collection<Group> customsDeclarationGroups = new ArrayList<>();

        Group currentWork = new Group();
        for (final String customsDeclaration : customsDeclarationData) {
            if ("".equals(customsDeclaration)) {
                customsDeclarationGroups.add(currentWork);
                currentWork = new Group();
            } else {
                currentWork.addCustomDeclaration(new CustomsDeclaration(customsDeclaration));
            }
        }
        customsDeclarationGroups.add(currentWork);

        final int sum = customsDeclarationGroups.stream().map(Group::getUnifiedQuestionsAnsweredWithTrue)
                                                .mapToInt(Set::size)
                                                .sum();

        assertThat(sum).isEqualTo(6);
    }

    @Test
    void getUnifiedQuestionsAnsweredWithTrue_whenChallengeInput_ShouldLogCountAnswers()
            throws URISyntaxException, IOException {
        final List<String> customsDeclarationData = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("06/challengeInput.txt").toURI()));

        final Collection<Group> customsDeclarationGroups = new ArrayList<>();

        Group currentWork = new Group();
        for (final String customsDeclaration : customsDeclarationData) {
            if ("".equals(customsDeclaration)) {
                customsDeclarationGroups.add(currentWork);
                currentWork = new Group();
            } else {
                currentWork.addCustomDeclaration(new CustomsDeclaration(customsDeclaration));
            }
        }
        customsDeclarationGroups.add(currentWork);

        final int sum = customsDeclarationGroups.stream().map(Group::getUnifiedQuestionsAnsweredWithTrue)
                                                .mapToInt(Set::size)
                                                .sum();

        System.out.println(sum);
    }
}
