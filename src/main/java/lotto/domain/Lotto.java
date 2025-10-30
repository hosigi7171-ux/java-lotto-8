package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersInRange(numbers);
        validateNotDuplicate(numbers);
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_NUMBER_COUNT_MISMATCH.getMessage(), LOTTO_NUMBER_COUNT));
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage(), LOTTO_NUMBER_MIN,
                            LOTTO_NUMBER_MAX));
        }
    }

    public boolean contains(int number) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        return distinctNumbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
