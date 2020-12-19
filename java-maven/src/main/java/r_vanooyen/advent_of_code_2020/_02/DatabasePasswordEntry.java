package r_vanooyen.advent_of_code_2020._02;

import java.util.ArrayList;
import java.util.List;

public class DatabasePasswordEntry implements Password {

    private final List<PasswordPolicy> policies = new ArrayList<>();
    private final String password;

    public DatabasePasswordEntry(String dbInput) {
        final int i = dbInput.indexOf(':');
        password = dbInput.substring(i + 2);
        policies.add(new AmountOfContainCharPasswordPolicy(dbInput.substring(0, i)));
    }

    @Override
    public boolean isValid() {
        return policies.stream().allMatch(policy -> policy.isPasswordValid(password));
    }
}
