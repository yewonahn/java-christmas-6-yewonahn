package christmas.enums;

public enum OutputMessage {
    CUT_TO_THOUSAND("#,###"),
    COMMENT_STARTING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    COMMENT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    COMMENT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1"),
    COMMENT_BENEFIT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    TITLE_ORDER("<주문 메뉴>"),
    ANSWER_MENU_QUANTITY("%s %d개\n"),
    TITLE_TOTAL_MENU_PRICE("<할인 전 총주문 금액>"),
    ANSWER_WON("%s원\n"),
    TITLE_GIFT_MENU("<증정 메뉴>"),
    ANSWER_STRING("%s\n"),
    TITLE_BENEFIT_DETAIL("<혜택 내역>"),
    NO("없음"),
    ANSWER_BENEFIT_PRICE("%s: -%s원\n"),
    TITLE_TOTAL_BENEFIT("<총혜택 금액>"),
    ANSWER_MINUS_TOTAL_BENEFIT("-%s원\n"),
    ANSWER_TOTAL_BENEFIT("%s원\n"),
    TITLE_PAYMENT_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    TITLE_EVENT_BADGE("<12월 이벤트 배지>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getOutputMessage() {
        return message;
    }
}
