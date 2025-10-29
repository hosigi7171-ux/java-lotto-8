package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoServiceImpl;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView(),
                new LottoServiceImpl());

        lottoController.runGame();
    }
}
