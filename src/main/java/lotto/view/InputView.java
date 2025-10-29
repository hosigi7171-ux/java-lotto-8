package lotto.view;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public interface InputView {
    PurchaseAmount readPurchaseAmount();

    WinningNumbers readWinningNumbers();
}
