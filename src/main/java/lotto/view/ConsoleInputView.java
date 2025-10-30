package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class ConsoleInputView implements InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public PurchaseAmount readPurchaseAmount() {
        while (true) {
            System.out.println(PROMPT_PURCHASE_AMOUNT);
            String input = Console.readLine();
            try {
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers readWinningNumbers() {
        Lotto winningLotto = readValidWinningLotto();
        BonusNumber bonusNumber = readValidBonusNumber();
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private Lotto readValidWinningLotto() {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            System.out.println(PROMPT_WINNING_NUMBER);
            try {
                winningLotto = readLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        return winningLotto;
    }

    private BonusNumber readValidBonusNumber() {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            System.out.println(PROMPT_BONUS_NUMBER);
            try {
                bonusNumber = readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        return bonusNumber;
    }

    private Lotto readLotto() {
        String input = Console.readLine();
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String wordNumber : splitInput) {
            numbers.add(Integer.parseInt(wordNumber));
        }
        return new Lotto(numbers);
    }

    private BonusNumber readBonusNumber() {
        String input = Console.readLine();
        return new BonusNumber(input);
    }
}
