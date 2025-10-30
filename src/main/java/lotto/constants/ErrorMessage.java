package lotto.constants;

public enum ErrorMessage {
    LOTTO_NUMBER_NOT_POSITIVE_NUMBER("[ERROR] 로또 숫자는 양의 정수여야 합니다."),
    LOTTO_NUMBER_NOT_IN_RANGE("[ERROR] 로또 숫자는 %d~%d까지 입니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복되면 안됩니다."),
    LOTTO_NUMBER_COUNT_MISMATCH("[ERROR] 로또 번호는 %d개여야 합니다."),

    PURCHASE_AMOUNT_NOT_MULTIPLE("[ERROR] 구입 금액은 %d로 나눠져야 합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE_NUMBER("[ERROR] 구입 금액은 양의 정수여야 합니다."),

    BONUS_NUMBER_NOT_POSITIVE_NUMBER("[ERROR] 보너스 숫자는 양의 정수여야 합니다."),
    BONUS_NUMBER_NOT_IN_RANGE("[ERROR] 보너스 숫자는 %d~%d까지 입니다."),

    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복되면 안됩니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
