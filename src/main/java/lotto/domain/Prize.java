package lotto.domain;

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
        for (Prize prize : values()) {
            if (prize.matchedNumberCount == matchedNumberCount
                    && prize.isMatchedBonusNumber == matchedBonusNumber) {
                return prize;
            }
        }
        // 2등(보너스)이 아닌 나머지 등수들 처리
        for (Prize prize : values()) {
            if (prize.matchedNumberCount == matchedNumberCount && !prize.isMatchedBonusNumber) {
                return prize;
            }
        }

        return null;
    }
}
