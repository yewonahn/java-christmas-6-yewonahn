package christmas.model;

public class CustomerEventInfo {
    private final String orderMenu;
    private final int totalOrderMoneyBeforeDiscount;
    private final String giftMenu;
    private final String benefitDetail;
    private final int totalBenefitMoney;
    private final int estimatedPaymentMoneyAfterDiscount;
    private final String decEventBadge;

    public CustomerEventInfo(String orderMenu, int totalOrderMoneyBeforeDiscount, String giftMenu, String benefitDetail, int totalBenefitMoney, int estimatedPaymentMoneyAfterDiscount, String decEventBadge) {
        this.orderMenu = orderMenu;
        this.totalOrderMoneyBeforeDiscount = totalOrderMoneyBeforeDiscount;
        this.giftMenu = giftMenu;
        this.benefitDetail = benefitDetail;
        this.totalBenefitMoney = totalBenefitMoney;
        this.estimatedPaymentMoneyAfterDiscount = estimatedPaymentMoneyAfterDiscount;
        this.decEventBadge = decEventBadge;
    }
}
