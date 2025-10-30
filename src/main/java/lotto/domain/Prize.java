package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;

public enum Prize {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);

    private final int matchedNumberCount;
    private final boolean isMatchedBonusNumber;
    private final long prizeMoney;

    Prize(int matchedNumberCount, boolean isMatchedBonusNumber, long prizeMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isMatchedBonusNumber() {
        return isMatchedBonusNumber;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 일치 개수와 보너스 번호 여부에 따라 당첨 등수를 반환
     *
     * @param matchedNumberCount 일치한 로또 번호 개수
     * @param matchedBonusNumber 보너스 번호 일치 여부
     * @return 해당하는 Prize, 없으면 null
     */
    public static Prize getMatchedPrize(int matchedNumberCount, boolean matchedBonusNumber) {
        // 일치하는 prize 를 반환
        for (Prize prize : values()) {
            if (prize.matchedNumberCount == matchedNumberCount
                    && prize.isMatchedBonusNumber == matchedBonusNumber) {
                return prize;
            }
        }
        // 숫자 전부 일치 + 보너스 숫자도 일치 -> 형식상 1등으로 취급하는게 맞을듯
        if(matchedNumberCount == LOTTO_NUMBER_COUNT){
            return FIRST;
        }
        return null;
    }
}
