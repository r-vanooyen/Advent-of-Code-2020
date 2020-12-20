package r_vanooyen.advent_of_code_2020._05;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SeatTest {
    @Test
    void receiveSeatId_whenGivenFBFBBFFRLR_shouldReturn357() {
        final Integer seatId = new Seat("FBFBBFFRLR").receiveSeatId();

        assertThat(seatId).isEqualTo(357);
    }

    @Test
    void receiveSeatId_whenGivenBFFFBBFRRR_shouldReturn357() {
        final Integer seatId = new Seat("BFFFBBFRRR").receiveSeatId();

        assertThat(seatId).isEqualTo(567);
    }

    @Test
    void receiveSeatId_whenGivenFFFBBBFRRR_shouldReturn357() {
        final Integer seatId = new Seat("FFFBBBFRRR").receiveSeatId();

        assertThat(seatId).isEqualTo(119);
    }

    @Test
    void receiveSeatId_whenGivenBBFFBBFRLL_shouldReturn357() {
        final Integer seatId = new Seat("BBFFBBFRLL").receiveSeatId();

        assertThat(seatId).isEqualTo(820);
    }

    @Test
    void receiveSeatId_whenGivenChallengeInput_shouldNotThrowExceptionsAndLogHighestId()
            throws URISyntaxException, IOException {

        Integer[] result = new Integer[1];
        assertThatCode(() -> result[0] = Files
                               .readAllLines(Paths.get(ClassLoader.getSystemResource("05/challengeInput.txt").toURI()))
                               .stream()
                               .map(Seat::new)
                               .mapToInt(Seat::receiveSeatId)
                               .max().getAsInt()
                      ).doesNotThrowAnyException();

        System.out.println("Highest Seatnumber is=" + result[0]);
    }

    @Test
    void receiveSeatId_whenGivenChallengeInput_shouldNotThrowExceptionsAndLogMissingNumbers()
            throws URISyntaxException, IOException {

        final List<Integer> results = new ArrayList<>();
        final List<String> challengeInputs =
                Files.readAllLines(Paths.get(ClassLoader.getSystemResource("05/challengeInput.txt").toURI()));

        assertThatCode(() -> results.addAll(challengeInputs
                                                    .stream()
                                                    .map(Seat::new)
                                                    .map(Seat::receiveSeatId).collect(Collectors.toList())))
                .doesNotThrowAnyException();

        Collections.sort(results);

        int currentSeat = results.get(0);
        for (int i = 0; i < results.size(); i++) {

            if (results.get(i) != currentSeat) {
                System.out.println("free seat " + currentSeat);
                i--;
            }
            currentSeat++;
        }
    }
}
