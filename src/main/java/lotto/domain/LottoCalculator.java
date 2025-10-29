package lotto.domain;

import static lotto.constants.LottoConstants.PURCHASE_AMOUNT_DIVISOR;

public class LottoCalculator {
    public int calculatePurchasableLottoCount(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_DIVISOR;
    }
}
