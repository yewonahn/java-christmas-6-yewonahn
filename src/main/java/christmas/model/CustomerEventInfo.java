package christmas.model;

import christmas.service.CalculateBenefitAmount;
import christmas.service.FillBenefitsDetailList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static christmas.controller.ChristmasController.customerInputInfo;
import static christmas.enums.OutputMessage.NO;

public class CustomerEventInfo {
    private List<Order> orders;
    private int totalOrderPriceBeforeDiscount;
    private String giftMenu;
    private List<EachBenefitDetail> benefitDetails;
    private int totalBenefitPrice;
    private int totalPaymentPriceAfterDiscount;
    private String decEventBadge;
    private final static String ONE_CHAMPAGNE = "샴페인 1개";

    public CustomerEventInfo(List<EachBenefitDetail> benefitDetails, int totalBenefitPrice, int totalPaymentPriceAfterDiscount) {
        setOrderMenu();
        setTotalOrderPriceBeforeDiscount();
        setGiftMenu();
        this.benefitDetails = benefitDetails;
        this.totalBenefitPrice = totalBenefitPrice;
        this.totalPaymentPriceAfterDiscount = totalPaymentPriceAfterDiscount;
        setDecEventBadge();
    }
    public void setOrderMenu() {
        orders = customerInputInfo.getOrders();
    }
    private void setTotalOrderPriceBeforeDiscount() {
        totalOrderPriceBeforeDiscount = customerInputInfo.getTotalPriceBeforeDiscount();
    }
    private void setGiftMenu() {
        if(customerInputInfo.checkPresent()) {
            giftMenu = ONE_CHAMPAGNE;
            return;
        }
        giftMenu = NO.getOutputMessage();
    }
    private void setDecEventBadge() {
        int totalBenefit = totalBenefitPrice;
        Badge badge = new Badge(totalBenefit);
        decEventBadge = badge.getState();
    }
    public List<Order> getOrders() {
        return orders;
    }
    public int getTotalOrderPriceBeforeDiscount() {
        return totalOrderPriceBeforeDiscount;
    }
    public String getGiftMenu() {
        return giftMenu;
    }
    public List<EachBenefitDetail> getBenefitDetails() {
        return benefitDetails;
    }
    public int getTotalBenefitPrice() {
        return totalBenefitPrice;
    }
    public int getTotalPaymentPriceAfterDiscount() {
        return totalPaymentPriceAfterDiscount;
    }
    public String getDecEventBadge() {
        return decEventBadge;
    }
}
