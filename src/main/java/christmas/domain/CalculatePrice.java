package christmas.service;

import christmas.model.CustomerInputInfo;
import christmas.model.Order;

import java.util.List;

public class CalculatePrice {
    private final static String DESERT = "<디저트>";
    private final static String MAIN_MENU = "<메인>";
    public static int christmasDDayBenefit (CustomerInputInfo customerInputInfo) {
        int visitDate = customerInputInfo.getVisitDate();
        int dDayBenefit = 1000 + (visitDate - 1) * 100;
        return dDayBenefit;
    }
    public static int weekdayBenefit(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekdayBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == DESERT) {
                weekdayBenefit += 2023 * order.getOrderQuantity();
            }
        }
        return weekdayBenefit;
    }
    public static int weekendBenefit(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekendBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == MAIN_MENU) {
                weekendBenefit += 2023;
            }
        }
        return weekendBenefit;
    }
    public static int specialDayBenefit(CustomerInputInfo customerInputInfo) {
        int specialDayBenefit = 0;
        if (customerInputInfo.checkSpecialDay()) {
            specialDayBenefit = 1000;
        }
        return specialDayBenefit;
    }
    public static int presentBenefit(CustomerInputInfo customerInputInfo) {
        int presentBenefit = 0;
        if (customerInputInfo.checkPresent()) {
            presentBenefit = 25000;
        }
        return presentBenefit;
    }
    public static int totalBenefit(CustomerInputInfo customerInputInfo) {
        int totalBenefit = 0;
        if (customerInputInfo.checkWeekday() && customerInputInfo.checkPriceCondition()) {
            totalBenefit = CalculatePrice.christmasDDayBenefit(customerInputInfo) + CalculatePrice.weekdayBenefit(customerInputInfo) + CalculatePrice.specialDayBenefit(customerInputInfo) + CalculatePrice.presentBenefit(customerInputInfo);
        }
        if (customerInputInfo.checkWeekend() && customerInputInfo.checkPriceCondition()) {
            totalBenefit = CalculatePrice.christmasDDayBenefit(customerInputInfo) + CalculatePrice.weekendBenefit(customerInputInfo) + CalculatePrice.specialDayBenefit(customerInputInfo) + CalculatePrice.presentBenefit(customerInputInfo);
        }
        return totalBenefit;
    }
    public static int totalDiscount(CustomerInputInfo customerInputInfo) {
        int totalDiscount = 0;
        if (customerInputInfo.checkWeekday() && customerInputInfo.checkPriceCondition()) {
            totalDiscount = CalculatePrice.christmasDDayBenefit(customerInputInfo) + CalculatePrice.weekdayBenefit(customerInputInfo) + CalculatePrice.specialDayBenefit(customerInputInfo);
        }
        if (customerInputInfo.checkWeekend() && customerInputInfo.checkPriceCondition()) {
            totalDiscount = CalculatePrice.christmasDDayBenefit(customerInputInfo) + CalculatePrice.weekendBenefit(customerInputInfo) + CalculatePrice.specialDayBenefit(customerInputInfo);
        }
        return totalDiscount;
    }
    public static int totalPaymentPriceAfterDiscount(CustomerInputInfo customerInputInfo) {
        int totalPaymentPriceAfterDiscount = customerInputInfo.getTotalPriceBeforeDiscount();
        if (customerInputInfo.checkPriceCondition()) {
            totalPaymentPriceAfterDiscount = customerInputInfo.getTotalPriceBeforeDiscount() - CalculatePrice.totalDiscount(customerInputInfo);
        }
        return totalPaymentPriceAfterDiscount;
    }
}
