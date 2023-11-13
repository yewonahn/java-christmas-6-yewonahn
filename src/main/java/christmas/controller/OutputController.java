package christmas.controller;

import christmas.model.CustomerEventInfo;
import christmas.model.CustomerInputInfo;
import christmas.model.EachBenefitDetail;
import christmas.model.Order;

import java.text.DecimalFormat;

import static christmas.controller.ChristmasController.customerInputInfo;
import static christmas.enums.OutputMessage.*;


public class OutputController {
    public static DecimalFormat df = new DecimalFormat(CUT_TO_THOUSAND.getOutputMessage());

    public static void startingComment() {
        System.out.println(COMMENT_STARTING.getOutputMessage());
    }

    public static void askVisitDate() {
        System.out.println(COMMENT_DATE.getOutputMessage());
    }

    public static void askOrderMenu() {
        System.out.println(COMMENT_ORDER.getOutputMessage());
    }

    public static void benefitPreviewComment(CustomerInputInfo customerInputInfo) {
        System.out.printf(COMMENT_BENEFIT_PREVIEW.getOutputMessage(), customerInputInfo.getVisitDate());
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printOrderMenu(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_ORDER.getOutputMessage());
        for(Order order : customerEventInfo.getOrders()) {
            System.out.printf(ANSWER_MENU_QUANTITY.getOutputMessage(), order.getOrderMenu(), order.getOrderQuantity());
        }
    }

    public static void printTotalOrderPriceBeforeDiscount(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_TOTAL_MENU_PRICE.getOutputMessage());
        String price = df.format(customerEventInfo.getTotalOrderPriceBeforeDiscount());
        System.out.printf(ANSWER_WON.getOutputMessage(), price);
    }

    public static void printGiftMenu(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_GIFT_MENU.getOutputMessage());
        System.out.printf(ANSWER_STRING.getOutputMessage(), customerEventInfo.getGiftMenu());
    }

    public static void printBenefitDetails(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_BENEFIT_DETAIL.getOutputMessage());
        if(!customerInputInfo.checkPriceCondition()) {
            System.out.println(NO.getOutputMessage());
            return;
        }
        for(EachBenefitDetail eachBenefitDetail : customerEventInfo.getBenefitDetails()) {
            String price = df.format(eachBenefitDetail.getBenefitPrice());
            System.out.printf(ANSWER_BENEFIT_PRICE.getOutputMessage(), eachBenefitDetail.getEventName(), price);
        }
    }

    public static void printTotalBenefitPrice(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_TOTAL_BENEFIT.getOutputMessage());
        String price = df.format(customerEventInfo.getTotalBenefitPrice());
        if (customerInputInfo.checkPriceCondition()) {
            System.out.printf(ANSWER_MINUS_TOTAL_BENEFIT.getOutputMessage(), price);
            return;
        }
        System.out.printf(ANSWER_TOTAL_BENEFIT.getOutputMessage(), price);
    }

    public static void printTotalPaymentPriceAfterDiscount(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_PAYMENT_PRICE_AFTER_DISCOUNT.getOutputMessage());
        String price = df.format(customerEventInfo.getTotalPaymentPriceAfterDiscount());
        System.out.printf(ANSWER_WON.getOutputMessage(), price);
    }

    public static void printDecEventBadge(CustomerEventInfo customerEventInfo) {
        System.out.println(TITLE_EVENT_BADGE.getOutputMessage());
        System.out.printf(ANSWER_STRING.getOutputMessage(), customerEventInfo.getDecEventBadge());
    }
}
