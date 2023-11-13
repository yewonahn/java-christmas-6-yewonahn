package christmas.service;

import christmas.model.CustomerInputInfo;
import christmas.model.Order;

import java.util.List;

import static christmas.controller.ChristmasController.customerInputInfo;

public class CalculateBenefitAmount {
    private final static String DESERT = "<디저트>";
    private final static String MAIN_MENU = "<메인>";
    public static int christmasDDay (CustomerInputInfo customerInputInfo) {
        int visitDate = customerInputInfo.getVisitDate();
        int dDayBenefit = 1000 + (visitDate - 1) * 100;
        return dDayBenefit;
    }
    public static int weekday(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekdayBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == DESERT) {
                weekdayBenefit += 2023 * order.getOrderQuantity();
            }
        }
        return weekdayBenefit;
    }
    public static int weekend(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekendBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == MAIN_MENU) {
                weekendBenefit += 2023;
            }
        }
        return weekendBenefit;
    }
    public static int specialDay(CustomerInputInfo customerInputInfo) {
        int specialDayBenefit = 0;
        if (customerInputInfo.checkSpecialDay()) {
            specialDayBenefit = 1000;
        }
        return specialDayBenefit;
    }
    public static int present(CustomerInputInfo customerInputInfo) {
        int presentBenefit = 0;
        if (customerInputInfo.checkPresent()) {
            presentBenefit = 25000;
        }
        return presentBenefit;
    }
    public static int totalBenefit() {
        int totalBenefit = 0;
        if (customerInputInfo.checkWeekday() || customerInputInfo.checkPriceCondition()) {
            totalBenefit = CalculateBenefitAmount.christmasDDay(customerInputInfo) + CalculateBenefitAmount.weekday(customerInputInfo) + CalculateBenefitAmount.specialDay(customerInputInfo) + CalculateBenefitAmount.present(customerInputInfo);
        }
        if (customerInputInfo.checkWeekend() || customerInputInfo.checkPriceCondition()) {
            totalBenefit = CalculateBenefitAmount.christmasDDay(customerInputInfo) + CalculateBenefitAmount.weekend(customerInputInfo) + CalculateBenefitAmount.specialDay(customerInputInfo) + CalculateBenefitAmount.present(customerInputInfo);
        }
        return totalBenefit;
    }
    public static int totalDiscount() {
        int totalDiscount = 0;
        if (customerInputInfo.checkWeekday() || customerInputInfo.checkPriceCondition()) {
            totalDiscount = CalculateBenefitAmount.christmasDDay(customerInputInfo) + CalculateBenefitAmount.weekday(customerInputInfo) + CalculateBenefitAmount.specialDay(customerInputInfo);
        }
        if (customerInputInfo.checkWeekend() || customerInputInfo.checkPriceCondition()) {
            totalDiscount = CalculateBenefitAmount.christmasDDay(customerInputInfo) + CalculateBenefitAmount.weekend(customerInputInfo) + CalculateBenefitAmount.specialDay(customerInputInfo);
        }
        return totalDiscount;
    }
}
