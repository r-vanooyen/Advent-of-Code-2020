package r_vanooyen.advent_of_code_2020._04;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Passport {
    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String passportId;

    private Integer countryId;

    @NotNull
    @Min(1920)
    @Max(2002)
    private Integer birthYear;

    @NotNull
    @Min(2010)
    @Max(2020)
    private Integer issueYear;

    @NotNull
    @Min(2020)
    @Max(2030)
    private Integer expirationYear;

    @NotBlank
    @Pattern(regexp = "^(((1(([5-8][0-9])|(9[0-3])))cm)|(((59)|([67][0-9])|(7[0-6]))in))$")
    private String height;

    @NotBlank
    @Pattern(regexp = "#[a-f0-9]{6}")
    private String hairColor;

    @NotBlank
    @Pattern(regexp = "amb|blu|brn|gry|grn|hzl|oth")
    private String eyeColor;

    public boolean isValid() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<Passport>> validate = validator.validate(this);
        return validate.isEmpty();
    }
}
