package lotto.domain;

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

    private void validate(BonusNumber bonusNumber){
        validateNotDuplicate(bonusNumber);
    }

    private void validateNotDuplicate(BonusNumber bonusNumber) {
        if(winningLotto.contains(bonusNumber.getValue())){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }
}
