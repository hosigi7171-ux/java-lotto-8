package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PrizeStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public interface LottoService {
    void makeLottos(PurchaseAmount purchaseAmount);

    /**
     * 당첨번호와 구입 금액을 받아서 당첨 횟수를 담은 통계를 반환해주는 메서드
     *
     * @param winningNumbers 당첨 번호: 당첨 로또 + 보너스 숫자
     * @param purchaseAmount 구입 금액
     * @return 등수 별 당첨 횟수를 담은 객체
     */
    PrizeStatistics matchAndCalculateStatistics(WinningNumbers winningNumbers, PurchaseAmount purchaseAmount);

    List<Lotto> getLottos();
}
