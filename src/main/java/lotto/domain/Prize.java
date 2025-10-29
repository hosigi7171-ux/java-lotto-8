package lotto.domain;

public enum Prize {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

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
     * 일치하는 숫자 개수에 해당하는 enum 을 리턴해주는 메서드
     *
     * @param matchedNumberCount 당첨로또와 일치하는 숫자 개수
     * @return 몇 등상
     */
    public static Prize getMatchedPrize(int matchedNumberCount) {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchedNumberCount() == matchedNumberCount) {
                return prize;
            }
        }
        return null;
    }
}
