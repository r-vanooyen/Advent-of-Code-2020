package r_vanooyen.advent_of_code_2020._03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RoadTripTest {

    @Test
    void lookupAmountOfTreesToPass_WhenGivenMiniTestInputAndSteps_shouldReturn2() throws Exception {
        final List<String> map = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("03/miniTestInput.txt").toURI()));

        final RoadTripImpl serviceUnderTest = new RoadTripImpl(map);

        final Long treesPassed = serviceUnderTest.lookupAmountOfTreesToPass(1, 1);

        assertThat(treesPassed).isEqualTo(2);
    }

    @Test
    void lookupAmountOfTreesToPass_WhenGivenTestInputAndSteps_shouldReturn7() throws Exception {
        final List<String> map = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("03/testInput.txt").toURI()));

        final RoadTripImpl serviceUnderTest = new RoadTripImpl(map);

        final Long treesPassed = serviceUnderTest.lookupAmountOfTreesToPass(3, 1);

        assertThat(treesPassed).isEqualTo(7);
    }

    @Test
    void lookupAmountOfTreesToPass_WhenGivenChallengeInputAndSteps_shouldNotThrowAnException() throws Exception {
        final List<String> map = Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource("03/challengeInput.txt").toURI()));

        final RoadTripImpl serviceUnderTest = new RoadTripImpl(map);

        final Long[] treesPassed = new Long[1];
        assertThatCode(() -> treesPassed[0] = serviceUnderTest.lookupAmountOfTreesToPass(3, 1))
                .doesNotThrowAnyException();

        System.out.println("trees passed=" + treesPassed[0]);
    }
}
