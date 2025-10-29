package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;

public class WinningNumbers {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        // 로또는 자체적으로 검증 완료
        this.winningLotto = winningLotto;

        // 보너스 숫자 검증
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber){
        validateNumberInRange(bonusNumber);
        validateNotDuplicate(bonusNumber);
    }

    private void validateNotDuplicate(int bonusNumber) {
        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private void validateNumberInRange(int number) {
        throw new IllegalArgumentException(
                String.format("[ERROR] 로또 숫자는 %d~%d까지 입니다.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
    }
}
