package r_vanooyen.advent_of_code_2020._05;

import javax.validation.constraints.Pattern;

public class Seat {

    private String seatSpecificationString;

    public Seat(@Pattern(regexp = "\\w{10}") String seatSpecificationString) {
        this.seatSpecificationString = seatSpecificationString;
    }

    public Integer receiveSeatId() {
        final String result = seatSpecificationString.replaceAll("F", "0")
                                                     .replaceAll("B", "1")
                                                     .replaceAll("L", "0")
                                                     .replaceAll("R", "1");

        return Integer.parseInt(result, 2);
    }
}
