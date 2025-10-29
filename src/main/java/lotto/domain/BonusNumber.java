package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

public class BonusNumber {
    private final int value;

    public BonusNumber(String input) {
        validate(input);
        value = Integer.parseInt(input);
    }

    private void validate(String input){
        validateNumber(input);
        validateNumberInRange(Integer.parseInt(input));
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 숫자는 양의 정수여야 합니다.");
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 숫자는 %d~%d까지 입니다.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
        }
    }

    public int getValue(){
        return value;
    }
}
