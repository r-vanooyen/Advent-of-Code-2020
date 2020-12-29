package r_vanooyen.advent_of_code_2020._06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    private final List<CustomsDeclaration> customsDeclarations = new ArrayList<>();

    public Group() {

    }

    public Group(Collection<String> answers) {
        answers.stream().map(CustomsDeclaration::new)
               .forEach(this::addCustomDeclaration);
    }

    public void addCustomDeclaration(CustomsDeclaration customsDeclaration) {
        customsDeclarations.add(customsDeclaration);
    }

    public Set<Character> getUniqueQuestionsAnsweredWithTrue() {
        return customsDeclarations.stream()
                                  .map(CustomsDeclaration::getQuestionsAnsweredWithTrue)
                                  .flatMap(Collection::stream)
                                  .collect(Collectors.toSet());
    }

    public Set<Character> getUnifiedQuestionsAnsweredWithTrue() {
        Set<Character> questionsAnsweredWithTrue = customsDeclarations.get(0).getQuestionsAnsweredWithTrue();
        for (int i = 1; i < customsDeclarations.size(); i++) {
            final Set<Character> currentAnswers = customsDeclarations.get(i).getQuestionsAnsweredWithTrue();

            questionsAnsweredWithTrue = questionsAnsweredWithTrue.stream()
                                                                 .filter(currentAnswers::contains)
                                                                 .collect(Collectors.toSet());
        }
        return questionsAnsweredWithTrue;
    }
}
