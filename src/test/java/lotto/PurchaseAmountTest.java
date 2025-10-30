package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void 구입_금액_정상_생성_테스트() {
        assertThat(new PurchaseAmount("15000").getValue()).isEqualTo(15000);
    }

    @Test
    void 구입_금액은_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("152125")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액은_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("asdf")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액을_1000으로_나눈_값_반환하는_메서드_기능_확인() {
        assertThat(new PurchaseAmount("15000").calculatePurchasableLottoCount()).isEqualTo(15);
    }
}
