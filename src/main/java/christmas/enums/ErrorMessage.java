package christmas.enums;

public enum ErrorMessage {
    DATE_ERROR_MSG("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_ERROR_MSG("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK_ERROR_MSG("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요."),
    MAX_MENU_ERROR_MSG("[ERROR] 메뉴는 한번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
