package vendingmachine.util;

public enum ExceptionMessage {

    EMPTY_PRODUCT("구매하려는 상품이 없습니다. 상품명을 확인해주세요."),
    INVALID_AMOUNT("10원으로 나누어 떨어지는 10원 이상의 금액을 입력해주세요."),
    INVALID_PRODUCT_AMOUNT("물품 개수를 1개 이상 입력해주세요."),
    INVALID_PRODUCT_SETTING_INFO("올바른 가격 또는 개수를 입력해주세요."),
    INVALID_INPUT_AMOUNT("투입 금액을 1원 이상 넣어주세요."),
    INVALID_INPUT_AMOUNT_STRING("투입 금액을 숫자로 입력해주세요.");

    private static final String TAG_ERROR = "[ERROR]";
    private final String message;

    ExceptionMessage(String message) {
        this.message = TAG_ERROR + message;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException(message);
    }
}
