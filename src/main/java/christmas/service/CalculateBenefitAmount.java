package christmas.service;

import christmas.model.CustomerInputInfo;
import christmas.model.Order;

import java.util.List;

import static christmas.Application.customerInputInfo;

public class CalculateBenefitAmount {
    public static int dDay (CustomerInputInfo customerInputInfo) {
        int visitDate = customerInputInfo.getVisitDate();
        int dDayBenefit = 1000 + (visitDate - 1) * 100;
        return dDayBenefit;
    }
    public static int weekday(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekdayBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == "<디저트>") {
                weekdayBenefit += 2023;
            }
        }
        return weekdayBenefit;
    }
    public static int weekend(CustomerInputInfo customerInputInfo) {
        List<Order> orders = customerInputInfo.getOrders();
        int weekendBenefit = 0;
        for (Order order : orders) {
            if (order.getCategory() == "<메인>") {
                weekendBenefit += 2023;
            }
        }
        return weekendBenefit;
    }
    public static int specialDay() {
        int specialDayBenefit = 1000;
        return specialDayBenefit;
    }
    public static int present() {
        int presentBenefit = 25000;
        return presentBenefit;
    }
    public static int totalBenefit() {
             int totalBenefit = CalculateBenefitAmount.dDay(customerInputInfo) + CalculateBenefitAmount.weekday(customerInputInfo) + CalculateBenefitAmount.weekend(customerInputInfo) + CalculateBenefitAmount.specialDay() + CalculateBenefitAmount.present();
             return totalBenefit;
    }
}
