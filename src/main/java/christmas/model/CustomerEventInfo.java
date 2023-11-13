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

    public CustomerEventInfo() {
        setOrderMenu();
        setTotalOrderPriceBeforeDiscount();
        setGiftMenu();
        setBenefitDetails();
        setTotalBenefitPrice();
        setTotalPaymentPriceAfterDiscount();
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
    private void setBenefitDetails() {
        benefitDetails = new ArrayList<>();
        if (customerInputInfo.checkPriceCondition()) {
            FillBenefitsDetailList.christmasDDay(this.benefitDetails);
            FillBenefitsDetailList.weekday(this.benefitDetails);
            FillBenefitsDetailList.weekend(this.benefitDetails);
            FillBenefitsDetailList.specialDay(this.benefitDetails);
            FillBenefitsDetailList.present(this.benefitDetails);
            return;
        }
        EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(NO.getOutputMessage(), 0);
        benefitDetails = new ArrayList<>(Arrays.asList(eachBenefitDetail));
    }
    private void setTotalBenefitPrice() {
        totalBenefitPrice = 0;
        if (customerInputInfo.checkPriceCondition()) {
            totalBenefitPrice = CalculateBenefitAmount.totalBenefit();
        }
    }
    private void setTotalPaymentPriceAfterDiscount() {
        totalPaymentPriceAfterDiscount = customerInputInfo.getTotalPriceBeforeDiscount();
        if (customerInputInfo.checkPriceCondition()) {
            totalPaymentPriceAfterDiscount = customerInputInfo.getTotalPriceBeforeDiscount() - CalculateBenefitAmount.totalDiscount();
        }
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
