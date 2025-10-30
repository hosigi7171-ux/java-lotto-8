package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.Prize;
import lotto.domain.PrizeStatistics;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class PrizeStatisticsTest {

    @Test
    void PrizeStatistics_정상_생성_확인() {
        Map<Prize, Integer> prizeResult = Map.of(
                Prize.FIFTH, 0,
                Prize.FOURTH, 1,
                Prize.THIRD, 0,
                Prize.SECOND, 1,
                Prize.FIRST, 0
        );
        PrizeStatistics prizeStatistics = new PrizeStatistics(prizeResult);

        assertThat(prizeStatistics.getPrizeCounter()).containsEntry(Prize.SECOND, 1)
                .containsEntry(Prize.FOURTH, 1).containsEntry(Prize.THIRD, 0);
    }

    @Test
    void calculateBenefitRate_정상_작동_확인() {
        Map<Prize, Integer> prizeResult = Map.of(
                Prize.FIRST, 1,
                Prize.SECOND, 1,
                Prize.THIRD, 0,
                Prize.FOURTH, 0,
                Prize.FIFTH, 2
        );
        PrizeStatistics stats = new PrizeStatistics(prizeResult);
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000000");

        double expectedBenefitRate = ((2_000_000_000L + 30_000_000L + 10_000L) / 1_000_000.0) * 100;
        assertThat(stats.calculateBenefitRate(purchaseAmount)).isEqualTo(expectedBenefitRate);
    }
}
