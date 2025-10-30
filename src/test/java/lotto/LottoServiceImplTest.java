package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceImplTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @Test
    void makeLottos_하면_정상적인_로또리스트가_생성된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");

        List<Lotto> lottos = lottoService.makeLottos(purchaseAmount);

        assertThat(lottos).hasSize(purchaseAmount.calculatePurchasableLottoCount());
    }

    @Test
    void matchAndCalculateStatistics_하면_정상_통계를_반환한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("15000");
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // FIRST
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7))); // SECOND
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 8, 11, 14))); // FIFTH

        PrizeStatistics prizeStatistics = lottoService.matchAndCalculateStatistics(winningNumbers, lottos,
                purchaseAmount);

        assertThat(prizeStatistics.getPrizeCounter().get(Prize.FIFTH)).isEqualTo(1);
        assertThat(prizeStatistics.getPrizeCounter().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeStatistics.getPrizeCounter().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeStatistics.getPrizeCounter().get(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeStatistics.getPrizeCounter().get(Prize.FIRST)).isEqualTo(1);
    }
}
