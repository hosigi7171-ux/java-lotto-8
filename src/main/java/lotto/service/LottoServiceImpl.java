package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class LottoServiceImpl implements LottoService {

    @Override
    public List<Lotto> makeLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT));
    }

    @Override
    public PrizeStatistics matchAndCalculateStatistics(WinningNumbers winningNumbers, List<Lotto> lottos,
                                                       PurchaseAmount purchaseAmount) {
        Map<Prize, Integer> prizeCounter = winningNumbers.match(lottos);
        return new PrizeStatistics(prizeCounter);
    }
}
