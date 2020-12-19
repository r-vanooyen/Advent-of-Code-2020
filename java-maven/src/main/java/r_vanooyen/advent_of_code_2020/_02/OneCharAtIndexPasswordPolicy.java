package r_vanooyen.advent_of_code_2020._02;

public class OneCharAtIndexPasswordPolicy implements PasswordPolicy {
    private final Integer indexOne;
    private final Integer indexTwo;
    private final char charToContain;

    public OneCharAtIndexPasswordPolicy(final String policyString) {
        final int indexSeparatingIndex = policyString.indexOf('-');
        final int charToContainIndex = policyString.indexOf(' ');
        indexOne = Integer.valueOf(policyString.substring(0, indexSeparatingIndex)) - 1;
        indexTwo = Integer.valueOf(policyString.substring(indexSeparatingIndex + 1, charToContainIndex)) - 1;
        charToContain = policyString.charAt(charToContainIndex + 1);
    }

    @Override
    public boolean isPasswordValid(final String password) {
        final char c1 = password.charAt(indexOne);
        final char c2 = password.charAt(indexTwo);
        return (charToContain == c1) ^ (charToContain == c2);
    }
}
