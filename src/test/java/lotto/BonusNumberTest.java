package lotto;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    void 보너스_숫자_정상_생성() {
        String input = "5";

        BonusNumber bonusNumber = new BonusNumber(input);

        assertThat(bonusNumber.getValue()).isEqualTo(5);
    }

    @Test
    void 보너스_숫자가_양의_정수가_아니면_오류() {
        assertThatThrownBy(() -> new BonusNumber("asdf")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
    }

    @Test
    void 보너스_숫자가_범위_안에_안들면_오류() {
        assertThatThrownBy(() -> new BonusNumber("99")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.BONUS_NUMBER_NOT_IN_RANGE.getMessage(), LOTTO_NUMBER_MIN,
                        LOTTO_NUMBER_MAX));
    }
}
