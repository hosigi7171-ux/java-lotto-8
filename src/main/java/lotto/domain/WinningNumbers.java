package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.ErrorMessage;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, BonusNumber bonusNumber) {
        // 로또는 자체적으로 검증 완료
        this.winningLotto = winningLotto;

        // 보너스 숫자 검증
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(BonusNumber bonusNumber) {
        validateNotDuplicate(bonusNumber);
    }

    private void validateNotDuplicate(BonusNumber bonusNumber) throws IllegalArgumentException{
        if (winningLotto.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    /**
     * 로또들에 대해서 일치하는 등수들을 체크해서 결과를 알아내는 메서드
     *
     * @param lottos 확인할 로또들
     * @return 키: 몇 등, 값: 횟수, 등수별로 몇회 해당하는지
     */
    public Map<Prize, Integer> match(List<Lotto> lottos) {
        Map<Prize, Integer> countResult = new HashMap<>();
        // 모든 Prize 에 대해서 0으로 세팅
        for(Prize prize : Prize.values()){
            countResult.put(prize, 0);
        }
        for (Lotto lotto : lottos) {
            Prize prize = getPrizeForLotto(lotto);
            // 등수에 해당하면
            if (prize != null) {
                plusCount(prize, countResult);
            }
        }
        return countResult;
    }

    /**
     * 로또에 해당하는 등수를 찾아주는 메서드
     *
     * @param lotto 확인할 로또
     * @return 해당하는 등수 enum
     */
    private Prize getPrizeForLotto(Lotto lotto) {
        int matchedCount = countMatchedLottoNumber(lotto);
        boolean matchedBonus = isLottoMatchedBonusNumber(lotto);
        return Prize.getMatchedPrize(matchedCount, matchedBonus);
    }


    private void plusCount(Prize prize, Map<Prize, Integer> countResult) {
        countResult.put(prize, countResult.getOrDefault(prize, 0) + 1);
    }

    private int countMatchedLottoNumber(Lotto lotto) {
        int count = 0;
        // 로또가 당첨 번호랑 몇 번 일치하는지 확인
        for (int number : lotto.getNumbers()) {
            if (isMatchedNumber(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatchedNumber(int number) {
        // 숫자가 당첨 번호에 해당하는지 확인
        for (int winningNumber : winningLotto.getNumbers()) {
            if (number == winningNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isLottoMatchedBonusNumber(Lotto lotto) {
        // 로또가 보너스 숫자를 가지고 있는지 확인
        for (int number : lotto.getNumbers()) {
            if (number == bonusNumber.getValue()) {
                return true;
            }
        }
        return false;
    }
}
