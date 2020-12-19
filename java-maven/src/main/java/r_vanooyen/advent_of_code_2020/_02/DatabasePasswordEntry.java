package r_vanooyen.advent_of_code_2020._02;

import java.util.ArrayList;
import java.util.List;

public class DatabasePasswordEntry implements Password {

    private final List<PasswordPolicy> policies = new ArrayList<>();
    private final String password;

    public DatabasePasswordEntry(String password) {
        this.password = password;
    }

    @Override
    public boolean isValid() {
        return policies.stream().allMatch(policy -> policy.isPasswordValid(password));
    }

    @Override
    public void addPasswordPolicy(final PasswordPolicy policy) {
        policies.add(policy);
    }
}
