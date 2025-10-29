package lotto.domain;

import java.util.Map;

public class PrizeStatistics {
    private final Map<Prize, Integer> prizeCounter;

    public PrizeStatistics(Map<Prize, Integer> prizeResult){
        this.prizeCounter = prizeResult;
    }

    /**
     * 수익률을 계산하는 메서드
     * @param purchaseAmount 구입 금액
     * @return 수익률
     */
    public double calculateBenefitRate(PurchaseAmount purchaseAmount){
        long totalBenefit = calculateTotalAmount();
        return (totalBenefit / (double)purchaseAmount.getValue()) * 100;
    }

    public long calculateTotalAmount(){
        long sum = 0;
        for(Prize prize : Prize.values()){
            sum += calculatePrizeAmount(prize);
        }
        return sum;
    }

    private long calculatePrizeAmount(Prize prize) {
        Integer count = prizeCounter.get(prize);
        if(count == null) return 0;
        return count * prize.getPrizeMoney();
    }
}
