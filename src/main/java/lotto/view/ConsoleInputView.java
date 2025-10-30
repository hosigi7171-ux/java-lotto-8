package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;
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
        System.out.println();
        // 보너스 숫자도 잘못 입력하면(ex: 중복되면) 보너스 숫자부터 입력 반복
        while(true){
            BonusNumber bonusNumber = readValidBonusNumber();
            System.out.println();
            try{
                return new WinningNumbers(winningLotto, bonusNumber);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto readValidWinningLotto() {
        while (true) {
            System.out.println(PROMPT_WINNING_NUMBER);
            try {
                return readLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber readValidBonusNumber() {
        while (true) {
            System.out.println(PROMPT_BONUS_NUMBER);
            try {
                return readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto readLotto() {
        String input = Console.readLine();
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String wordNumber : splitInput) {
            try {
                numbers.add(Integer.parseInt(wordNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
            }
        }
        return new Lotto(numbers);
    }

    private BonusNumber readBonusNumber() {
        String input = Console.readLine();
        return new BonusNumber(input);
    }
}
