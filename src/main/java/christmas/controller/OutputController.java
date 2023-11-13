package christmas.controller;

import christmas.model.CustomerEventInfo;
import christmas.model.CustomerInputInfo;
import christmas.model.EachBenefitDetail;
import christmas.model.Order;

import java.text.DecimalFormat;

import static christmas.controller.ChristmasController.customerInputInfo;


public class OutputController {
    public static DecimalFormat df = new DecimalFormat("#,###");

    public static void startingComment() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void askVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void askOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void benefitPreviewComment(CustomerInputInfo customerInputInfo) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", customerInputInfo.getVisitDate());
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printOrderMenu(CustomerEventInfo customerEventInfo) {
        System.out.println("<주문 메뉴>");
        for(Order order : customerEventInfo.getOrders()) {
            System.out.printf("%s %d개\n", order.getOrderMenu(), order.getOrderQuantity());
        }
    }

    public static void printTotalOrderPriceBeforeDiscount(CustomerEventInfo customerEventInfo) {
        System.out.println("<할인 전 총주문 금액>");
        String price = df.format(customerEventInfo.getTotalOrderPriceBeforeDiscount());
        System.out.printf("%s원\n", price);
    }

    public static void printGiftMenu(CustomerEventInfo customerEventInfo) {
        System.out.println("<증정 메뉴>");
        System.out.printf("%s\n", customerEventInfo.getGiftMenu());
    }

    public static void printBenefitDetails(CustomerEventInfo customerEventInfo) {
        System.out.println("<혜택 내역>");
        if(!customerInputInfo.checkPriceCondition()) {
            System.out.println("없음");
            return;
        }
        for(EachBenefitDetail eachBenefitDetail : customerEventInfo.getBenefitDetails()) {
            String price = df.format(eachBenefitDetail.getBenefitPrice());
            System.out.printf("%s: -%s원\n", eachBenefitDetail.getEventName(), price);
        }
    }

    public static void printTotalBenefitPrice(CustomerEventInfo customerEventInfo) {
        System.out.println("<총혜택 금액>");
        String price = df.format(customerEventInfo.getTotalBenefitPrice());
        System.out.printf("-%s원\n", price);
    }

    public static void printTotalPaymentPriceAfterDiscount(CustomerEventInfo customerEventInfo) {
        System.out.println("<할인 후 예상 결제 금액>");
        String price = df.format(customerEventInfo.getTotalPaymentPriceAfterDiscount());
        System.out.printf("%s원\n", price);
    }

    public static void printDecEventBadge(CustomerEventInfo customerEventInfo) {
        System.out.println("<12월 이벤트 배지>");
        System.out.printf("%s\n", customerEventInfo.getDecEventBadge());
    }
}
