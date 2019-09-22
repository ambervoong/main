package seedu.address.model.entity.worker;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;
import java.util.regex.Pattern;

//@@author ambervoong
/**
 *  Represents a worker's identification number in Mortago.
 */
public class WorkerIdentificationNumber {
    public static final String VALID_ID = "A valid worker identification number has a length of 6, "
            + "starts with 'W', which is followed by 5 digits.";
    private final String identificationNumber;

    public WorkerIdentificationNumber(String identificationNumber) {
        requireNonNull(identificationNumber);
        checkArgument(isValidIdentificationNumber(identificationNumber), VALID_ID);
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkerIdentificationNumber that = (WorkerIdentificationNumber) o;
        return getIdentificationNumber().equals(that.getIdentificationNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentificationNumber());
    }

    /**
     * Checks if a given string is a valid body identification number. A valid body identification number has a
     * length of 6, starts with 'W', which is followed by 5 digits.
     * @param identificationNumber String that represents a given worker identification number.
     * @return true if the string is a valid worker identification number, false otherwise.
     */
    public static boolean isValidIdentificationNumber(String identificationNumber) {
        if (identificationNumber.length() != 6) {
            return false;
        }

        String digits = identificationNumber.substring(1);

        boolean isStartB = identificationNumber.charAt(0) == 'W';
        boolean isFiveLength = digits.length() == 5;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        boolean isDigits = (pattern.matcher(digits).matches());

        return isStartB && isFiveLength && isDigits;
    }
}
