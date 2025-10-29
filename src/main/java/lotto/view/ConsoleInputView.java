package lotto.view;

import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_DIVISOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

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

    public WinningNumbers readWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = readLotto();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = readBonusNumber();
        System.out.println();
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private int readBonusNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private Lotto readLotto(){
        String input = Console.readLine();
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for(String wordNumber : splitInput){
            numbers.add(Integer.parseInt(wordNumber));
        }
        return new Lotto(numbers);
    }
}
