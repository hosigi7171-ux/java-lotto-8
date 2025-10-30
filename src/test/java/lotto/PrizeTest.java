package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    void Prize_필드값_확인() {
        assertThat(Prize.FIFTH.getMatchedNumberCount()).isEqualTo(3);
        assertThat(Prize.FOURTH.getMatchedNumberCount()).isEqualTo(4);
        assertThat(Prize.THIRD.getMatchedNumberCount()).isEqualTo(5);
        assertThat(Prize.SECOND.getMatchedNumberCount()).isEqualTo(5);
        assertThat(Prize.FIRST.getMatchedNumberCount()).isEqualTo(6);

        assertThat(Prize.FIFTH.isMatchedBonusNumber()).isEqualTo(false);
        assertThat(Prize.FOURTH.isMatchedBonusNumber()).isEqualTo(false);
        assertThat(Prize.THIRD.isMatchedBonusNumber()).isEqualTo(false);
        assertThat(Prize.SECOND.isMatchedBonusNumber()).isEqualTo(true);
        assertThat(Prize.FIRST.isMatchedBonusNumber()).isEqualTo(false);

        assertThat(Prize.FIFTH.getPrizeMoney()).isEqualTo(5_000L);
        assertThat(Prize.FOURTH.getPrizeMoney()).isEqualTo(50_000L);
        assertThat(Prize.THIRD.getPrizeMoney()).isEqualTo(1_500_000L);
        assertThat(Prize.SECOND.getPrizeMoney()).isEqualTo(30_000_000L);
        assertThat(Prize.FIRST.getPrizeMoney()).isEqualTo(2_000_000_000L);
    }

    @Test
    void getMatchedPrize_일치한_숫자_개수에_맞는_Prize_반환한다() {
        assertThat(Prize.getMatchedPrize(3, false)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.getMatchedPrize(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.getMatchedPrize(5, true)).isEqualTo(Prize.SECOND);
    }

    @Test
    void getMatchedPrize_일치한_숫자_개수에_맞는_Prize가_없으면_null_반환한다(){
        assertThat(Prize.getMatchedPrize(1, false)).isNull();
    }
}
