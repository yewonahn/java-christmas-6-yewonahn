package christmas.view;

import christmas.controller.OutputController;

import static christmas.controller.ChristmasController.customerEventInfo;
import static christmas.controller.ChristmasController.customerInputInfo;

public class EventPlannerView {
    public static void benefitPreviewCommentView() {
        OutputController.benefitPreviewComment(customerInputInfo);
        OutputController.printEnter();
    }
    public static void orderMenuView() {
        OutputController.printOrderMenu(customerEventInfo);
        OutputController.printEnter();
    }
    public static void totalOrderPriceBeforeDiscountView() {
        OutputController.printTotalOrderPriceBeforeDiscount(customerEventInfo);
        OutputController.printEnter();
    }
    public static void giftMenuView() {
        OutputController.printGiftMenu(customerEventInfo);
        OutputController.printEnter();
    }
    public static void benefitDetailsView() {
        OutputController.printBenefitDetails(customerEventInfo);
        OutputController.printEnter();
    }
    public static void totalBenefitPriceView() {
        OutputController.printTotalBenefitPrice(customerEventInfo);
        OutputController.printEnter();
    }
    public static void totalPaymentPriceAfterDiscountView() {
        OutputController.printTotalPaymentPriceAfterDiscount(customerEventInfo);
        OutputController.printEnter();
    }
    public static void decEventBadgeView() {
        OutputController.printDecEventBadge(customerEventInfo);
        OutputController.printEnter();
    }
}
