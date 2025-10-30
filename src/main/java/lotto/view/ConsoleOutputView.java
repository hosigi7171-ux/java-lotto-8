package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class ConsoleOutputView implements OutputView {
    private static final String PROMPT_PURCHASED_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    private static final String PROMPT_STATISTICS_TITLE = "당첨 통계";
    private static final String PROMPT_SEPARATOR = "---";
    private static final String PROMPT_MATCHING_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String PROMPT_MATCHING_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개 %n";
    private static final String PROMPT_BENEFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(PROMPT_PURCHASED_LOTTO_COUNT_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printStatistics(Map<Prize, Integer> prizeCounter) {
        System.out.println(PROMPT_STATISTICS_TITLE);
        System.out.println(PROMPT_SEPARATOR);

        for (Prize prize : Prize.values()) {
            int count = prizeCounter.get(prize);
            String message = PROMPT_MATCHING_FORMAT;
            if(prize.isMatchedBonusNumber()){
                message = PROMPT_MATCHING_BONUS_FORMAT;
            }
            System.out.printf(message, prize.getMatchedNumberCount(), prize.getPrizeMoney(), count);
        }
    }

    public void printBenefitRate(double benefitRate){
        System.out.println();
        // 소수점 둘째 자리에서 반올림
        System.out.printf(PROMPT_BENEFIT_RATE_FORMAT, benefitRate);
    }
}
