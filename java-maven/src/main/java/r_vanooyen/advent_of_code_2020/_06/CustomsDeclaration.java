package r_vanooyen.advent_of_code_2020._06;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomsDeclaration {

    private final Set<Character> questionsAnsweredWithTrue;

    public CustomsDeclaration(final String answerStringCode) {
        questionsAnsweredWithTrue = answerStringCode.chars()
                                                    .filter(value -> value != 10)
                                                    .mapToObj(character -> (char) character)
                                                    .collect(Collectors.toSet());
    }

    public Set<Character> getQuestionsAnsweredWithTrue() {
        return questionsAnsweredWithTrue;
    }
}
