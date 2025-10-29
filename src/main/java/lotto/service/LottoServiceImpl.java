package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoServiceImpl implements LottoService {
    private final List<Lotto> lottos;

    public LottoServiceImpl() {
        lottos = new ArrayList<>();
    }

    public void makeLottos(int lottoCount) {
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT));
    }
}
