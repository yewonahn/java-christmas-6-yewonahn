package christmas.model;

public class CustomerEventInfo {
    private final String orderMenu;
    private final int totalOrderPriceBeforeDiscount;
    private final String giftMenu;
    private final String benefitDetail;
    private final int totalBenefitPrice;
    private final int totalPaymentPriceAfterDiscount;
    private final String decEventBadge;

    public CustomerEventInfo(String orderMenu, int totalOrderPriceBeforeDiscount, String giftMenu, String benefitDetail, int totalBenefitPrice, int totalPaymentPriceAfterDiscount, String decEventBadge) {
        this.orderMenu = orderMenu;
        this.totalOrderPriceBeforeDiscount = totalOrderPriceBeforeDiscount;
        this.giftMenu = giftMenu;
        this.benefitDetail = benefitDetail;
        this.totalBenefitPrice = totalBenefitPrice;
        this.totalPaymentPriceAfterDiscount = totalPaymentPriceAfterDiscount;
        this.decEventBadge = decEventBadge;
    }
}
