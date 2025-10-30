package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void WinningNumbers는_중복된_숫자면_예외가_빨생한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("5");

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void match_메서드는_로또_리스트에_대한_등수별_카운트를_반환한다(){
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6))); // FIRST
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,6,7))); // SECOND
        lottos.add(new Lotto(Arrays.asList(1,3,5,8,11,14))); // FIFTH

        Map<Prize, Integer> result = winningNumbers.match(lottos);

        assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.THIRD)).isEqualTo(0);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
    }
}
