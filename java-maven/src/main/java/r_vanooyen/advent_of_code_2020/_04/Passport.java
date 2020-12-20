package r_vanooyen.advent_of_code_2020._04;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Passport {
    @NotBlank
    private String passportId;

    private Integer countryId;

    @NotNull
    private Integer birthYear;

    @NotNull
    private Integer issueYear;

    @NotNull
    private Integer expirationYear;

    @NotBlank
    private String height;

    @NotBlank
    private String hairColor;

    @NotBlank
    private String eyeColor;

    public boolean isValid() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<Passport>> validate = validator.validate(this);
        return validate.isEmpty();
    }
}
