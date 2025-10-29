package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public interface OutputView {
    void printLottos(List<Lotto> lottos);

    void printStatistics(Map<Prize, Integer> prizeCounter);

    void printBenefitRate(double benefitRate);
}
