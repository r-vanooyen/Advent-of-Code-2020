package r_vanooyen.advent_of_code_2020._07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagRule {

    private String rules;

    public BagRule(String rules) {
        this.rules = rules;
    }

    public Set<String> bagColorWhichCanContain(String bagColor) {
        final Pattern pattern = Pattern.compile("^(.*) bags contain .*" + bagColor + ".*$", Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(rules);

        final Set<String> matches = new HashSet<>();
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }
        return matches;
    }

    public Set<String> allBagColorsWhichCanContain(String bagColor) {
        final Set<String> colors = bagColorWhichCanContain(bagColor);
        final Set<String> results = new HashSet<>(colors);
        for (final String color : colors) {
            results.addAll(allBagColorsWhichCanContain(color));
        }
        return results;
    }

    public List<String> bagColorsWhichCanBeWithin(String bagColor) {
        final Pattern pattern = Pattern.compile("^" + bagColor + " bags contain (.*)$",
                                                Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(rules);

        final List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            final String subString = matcher.group(1);
            final Pattern subPattern = Pattern.compile("(\\d) (.*?) bag");
            final Matcher subMatcher = subPattern.matcher(subString);

            while (subMatcher.find()) {
                final String amount = subMatcher.group(1);
                final String color = subMatcher.group(2);
                for (int i = 0; i < Integer.parseInt(amount); i++) {
                    matches.add(color);
                }
            }
        }
        return matches;
    }

    public List<String> allBagColorsWhichCanBeWithin(String bagColor) {
        final List<String> colors = bagColorsWhichCanBeWithin(bagColor);
        final List<String> results = new ArrayList<>(colors);
        for (final String color : colors) {
            results.addAll(allBagColorsWhichCanBeWithin(color));
        }
        return results;
    }
}
