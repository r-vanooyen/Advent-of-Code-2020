package r_vanooyen.advent_of_code_2020._02;

public class AmountOfContainCharPasswordPolicy implements PasswordPolicy {

    private final Character charToContain;
    private final int atLeast;
    private final int atMost;

    public AmountOfContainCharPasswordPolicy(char charToContain, int atLeast, int atMost) {

        this.charToContain = charToContain;
        this.atLeast = atLeast;
        this.atMost = atMost;
    }

    public AmountOfContainCharPasswordPolicy(String policyString) {
        final int amountLimitIndex = policyString.indexOf('-');
        final int charToContainIndex = policyString.indexOf(' ');
        atLeast = Integer.valueOf(policyString.substring(0, amountLimitIndex));
        atMost = Integer.valueOf(policyString.substring(amountLimitIndex + 1, charToContainIndex));
        charToContain = policyString.charAt(charToContainIndex + 1);
    }

    @Override
    public boolean isPasswordValid(final String password) {
        final long count = password.chars().mapToObj(value -> (char) value)
                                   .filter(charToContain::equals)
                                   .count();
        return ((count >= atLeast) && (count <= atMost));
    }
}
