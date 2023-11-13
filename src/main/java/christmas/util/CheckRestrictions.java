package christmas.util;

import christmas.model.Order;

import java.util.List;

public class CheckRestrictions {
    public static boolean orderOnlyDrink(List<Order> orders) {
        for(Order order : orders) {
            if(!order.getCategory().equals("<음료>")) {
                return true;
            }
        }
        return false;
    }

    public static boolean maxAmountOfMenu(List<Order> orders) {
        int amountOfMenu = 0;
        for(Order order : orders) {
            amountOfMenu += order.getOrderQuantity();
        }
        if(amountOfMenu <= 20) {
            return true;
        }
        return false;
    }
}
