package christmas.controller;

import christmas.model.CustomerEventInfo;
import christmas.model.CustomerInputInfo;
import christmas.model.Order;

import java.util.List;

import static christmas.view.EventPlannerView.*;

public class ChristmasController {
    public static CustomerInputInfo customerInputInfo;
    public static CustomerEventInfo customerEventInfo;

    public static void run() {
        programStart();
        customerInputOrder();
        printEventPlannerView();
    }
    public static void programStart() {
        OutputController.startingComment();
    }
    public static void customerInputOrder() {
        OutputController.askVisitDate();
        int visitDate = InputController.inputVisitDate();

        OutputController.askOrderMenu();
        List<Order> orders = InputController.inputOrderMenu();

        createInfoClass(orders, visitDate);
    }
    public static void createInfoClass(List<Order> orders, int visitDate) {
        customerInputInfo = new CustomerInputInfo(orders, visitDate);
        customerEventInfo = new CustomerEventInfo();
    }

    public static void printEventPlannerView() {
        benefitPreviewCommentView();
        orderMenuView();
        totalOrderPriceBeforeDiscountView();
        giftMenuView();
        benefitDetailsView();
        totalBenefitPriceView();
        totalPaymentPriceAfterDiscountView();
        decEventBadgeView();
    }
}
