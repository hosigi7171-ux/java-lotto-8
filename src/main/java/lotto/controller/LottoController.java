package lotto.controller;

import lotto.domain.PrizeStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void runGame() {
        // 구입 금액 입력
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();

        // 로또들 만들고 출력하기
        lottoService.makeLottos(purchaseAmount);
        outputView.printLottos(lottoService.getLottos());

        // 당첨 번호 입력받고 통계 결과 만들기
        WinningNumbers winningNumbers = inputView.readWinningNumbers();
        PrizeStatistics statistics = lottoService.matchAndCalculateStatistics(winningNumbers, purchaseAmount);

        // 최종 결과 출력
        outputView.printStatistics(statistics.getPrizeCounter());
        outputView.printBenefitRate(statistics.calculateBenefitRate(purchaseAmount));
    }
}
