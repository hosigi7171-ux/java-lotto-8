package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

import lotto.constants.ErrorMessage;

public class BonusNumber {
    private final int value;

    public BonusNumber(String input) {
        validate(input);
        value = Integer.parseInt(input);
    }

    private void validate(String input) {
        validateNumber(input);
        validateNumberInRange(Integer.parseInt(input));
    }

    private void validateNumber(String input) throws IllegalArgumentException{
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(int number) throws IllegalArgumentException{
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.BONUS_NUMBER_NOT_IN_RANGE.getMessage(), LOTTO_NUMBER_MIN,
                            LOTTO_NUMBER_MAX));
        }
    }

    public int getValue() {
        return value;
    }
}
