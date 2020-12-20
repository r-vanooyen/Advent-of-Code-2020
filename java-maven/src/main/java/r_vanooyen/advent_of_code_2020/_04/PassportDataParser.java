package r_vanooyen.advent_of_code_2020._04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jetbrains.annotations.NotNull;

public class PassportDataParser {
    private static final String PASSPORT_DATA_SEPARATOR = "";

    @NotNull
    public Collection<Passport> parseInput(@NotNull final List<String> inputs) {
        return parseInput(inputs.toArray(new String[0]));
    }

    @NotNull
    public Collection<Passport> parseInput(@NotNull final String... inputs) {
        final List<Passport> passports = new ArrayList<>();
        if (inputs.length == 0) {
            return passports;
        }

        Passport.PassportBuilder builder = Passport.builder();
        for (final String input : inputs) {
            if (PASSPORT_DATA_SEPARATOR.equals(input)) {
                passports.add(builder.build());
                builder = Passport.builder();
                continue;
            }
            final String[] attributes = input.split(" ");
            for (final String attribute : attributes) {
                try {
                    final String[] attrKeyValue = attribute.split(":");
                    switch (attrKeyValue[0]) {
                        case "ecl":
                            builder.eyeColor(attrKeyValue[1]);
                            break;
                        case "pid":
                            builder.passportId(attrKeyValue[1]);
                            break;
                        case "eyr":
                            builder.expirationYear(Integer.valueOf(attrKeyValue[1]));
                            break;
                        case "hcl":
                            builder.hairColor(attrKeyValue[1]);
                            break;
                        case "byr":
                            builder.birthYear(Integer.valueOf(attrKeyValue[1]));
                            break;
                        case "iyr":
                            builder.issueYear(Integer.valueOf(attrKeyValue[1]));
                            break;
                        case "cid":
                            builder.countryId(Integer.valueOf(attrKeyValue[1]));
                            break;
                        case "hgt":
                            builder.height(attrKeyValue[1]);
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("cannot parse attr " + attribute);
                }
            }
        }

        passports.add(builder.build());

        return passports;
    }
}
