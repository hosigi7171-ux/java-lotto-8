package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class ConsoleOutputView implements OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(Map<Prize, Integer> prizeCounter) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Prize prize : Prize.values()) {
            int count = prizeCounter.get(prize);
            System.out.printf("%d개 일치 (%,d원) - %d개%n", prize.getMatchedNumberCount(), prize.getPrizeMoney(), count);
        }
    }

    public void printBenefitRate(double benefitRate){
        // 소수점 둘째 자리에서 반올림
        System.out.printf("총 수익률은 %.1f%%입니다.%n", benefitRate);
    }
}
