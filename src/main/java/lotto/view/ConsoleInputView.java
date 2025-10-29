package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class ConsoleInputView implements InputView {

    public PurchaseAmount readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return new PurchaseAmount(input);
    }

    public WinningNumbers readWinningNumbers(){
        // 로또 당첨 번호 읽기
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = readLotto();
        System.out.println();

        // 보너스 번호 읽기
        System.out.println("보너스 번호를 입력해 주세요.");
        BonusNumber bonusNumber = readBonusNumber();
        System.out.println();

        return new WinningNumbers(winningLotto, bonusNumber);
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

    private BonusNumber readBonusNumber() {
        String input = Console.readLine();
        return new BonusNumber(input);
    }
}
