package lotto.view;

import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_DIVISOR;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private void validatePurchaseAmount(String input) {
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
}
