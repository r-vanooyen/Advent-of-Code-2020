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
                     .map(DatabasePasswordEntry::new)
                     .filter(DatabasePasswordEntry::isValid)
                     .count();
    }
}
