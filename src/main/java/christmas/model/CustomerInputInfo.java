package christmas.model;

import christmas.service.GetDayOfTheWeek;

import java.util.List;

import static christmas.enums.EventName.WEEKDAY;
import static christmas.enums.EventName.WEEKEND;

public class CustomerInputInfo {
    private final List<Order> orders;
    private final int visitDate;
    private final String dayOfTheWeek;

    public CustomerInputInfo(List<Order> orders, int visitDate) {
        this.orders = orders;
        this.visitDate = visitDate;
        this.dayOfTheWeek = GetDayOfTheWeek.getDayOfTheWeek(visitDate);
    }
    public boolean checkChristmasDDay() {
        if (visitDate <= 25) {
            return true;
        }
        return false;
    }
    public boolean checkWeekday() {
        if (dayOfTheWeek == WEEKDAY.getEventName()) {
            return true;
        }
        return false;
    }
    public boolean checkWeekend() {
        if (dayOfTheWeek == WEEKEND.getEventName()) {
            return true;
        }
        return false;
    }
    public boolean checkSpecialDay() {
        if (visitDate % 7 == 3 || visitDate == 25) {
            return true;
        }
        return false;
    }
    public boolean checkPresent() {
        int totalPriceBeforeDiscount = getTotalPriceBeforeDiscount();
        if (totalPriceBeforeDiscount >= 120000) {
            return true;
        }
        return false;
    }
    public int getTotalPriceBeforeDiscount() {
        int totalPriceBeforeDiscount = 0;
        for(Order order : orders) {
            totalPriceBeforeDiscount += order.getEachMenuTotalPrice();
        }
        return totalPriceBeforeDiscount;
    }
    public boolean checkPriceCondition() {
        int totalPriceBeforeDiscount = getTotalPriceBeforeDiscount();
        if(totalPriceBeforeDiscount >= 10000) {
            return true;
        }
        return false;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public int getVisitDate() {
        return visitDate;
    }
}