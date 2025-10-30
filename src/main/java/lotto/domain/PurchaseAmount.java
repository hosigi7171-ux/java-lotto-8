package lotto.domain;

import lotto.constants.ErrorMessage;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_DIVISOR = 1000;

    private final int value;

    public PurchaseAmount(String input) {
        validate(input);
        this.value = Integer.parseInt(input);
    }

    private void validate(String input) {
        validateNumber(input);
        validateDivisibleByThousand(input);
    }

    private void validateDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number % PURCHASE_AMOUNT_DIVISOR != 0) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage(), PURCHASE_AMOUNT_DIVISOR));
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    public int calculatePurchasableLottoCount() {
        return value / PURCHASE_AMOUNT_DIVISOR;
    }

    public int getValue() {
        return value;
    }
}
