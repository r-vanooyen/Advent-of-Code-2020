package r_vanooyen.advent_of_code_2020._02;

public interface DatabasePasswordChecker {

    long lookupAmountOfValidPasswords(Password... passwords);

    long lookupAmountOfValidPasswords(String... dbInputs);

    long lookupAmountOfNewValidPasswords(String... dbInputStream);
}
