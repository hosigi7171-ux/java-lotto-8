package lotto.domain;

import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_DIVISOR;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(String input){
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
            throw new IllegalArgumentException(String.format("구입 금액은 %d로 나눠져야 합니다.", PURCHASE_AMOUNT_DIVISOR));
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 양의 정수여야 합니다.");
        }
    }

    public int calculatePurchasableLottoCount() {
        return value / PURCHASE_AMOUNT_DIVISOR;
    }

    public int getValue(){
        return value;
    }
}
