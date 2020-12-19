package r_vanooyen.advent_of_code_2020._02;

import java.util.Arrays;

public class DatabasePasswordCheckerImpl implements DatabasePasswordChecker {
    @Override
    public long lookupAmountOfValidPasswords(final Password... passwords) {
        return Arrays.stream(passwords)
                     .filter(Password::isValid)
                     .count();
    }

    public long lookupAmountOfValidPasswords(String... dbInputStream) {
        return Arrays.stream(dbInputStream)
                     .map(s -> {
                         final String[] split = s.split(": ");
                         final DatabasePasswordEntry passwordEntry = new DatabasePasswordEntry(split[1]);
                         passwordEntry.addPasswordPolicy(new AmountOfContainCharPasswordPolicy(split[0]));
                         return passwordEntry;
                     })
                     .filter(DatabasePasswordEntry::isValid)
                     .count();
    }

    @Override
    public long lookupAmountOfNewValidPasswords(String... dbInputStream) {
        return Arrays.stream(dbInputStream)
                     .map(s -> {
                         final String[] split = s.split(": ");
                         final DatabasePasswordEntry passwordEntry = new DatabasePasswordEntry(split[1]);
                         passwordEntry.addPasswordPolicy(new OneCharAtIndexPasswordPolicy(split[0]));
                         return passwordEntry;
                     })
                     .filter(DatabasePasswordEntry::isValid)
                     .count();
    }
}
