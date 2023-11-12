package christmas.util;

import christmas.enums.Menu;
import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CheckValidation {
    public static void checkDateType(String stringVisitDate) {
        try {
            int date = Integer.parseInt(stringVisitDate);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkMenuAmount(String stringQuantity) {
        try {
            int quantity = Integer.parseInt(stringQuantity);
            if (quantity < 1 || quantity > 20) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkMenuValid(List<Order> orders) {
        for(Order order : orders) {
            if(! Menu.checkRightName(order.getOrderMenu())) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkMenuDuplication(List<Order> orders) {
        List<String> menuNames = new ArrayList<>();
        for(Order order : orders) {
            menuNames.add(order.getOrderMenu());
        }
        List<String> duplicationTest = menuNames.stream().distinct().toList();
        if (menuNames.size() != duplicationTest.size()) {
            throw new IllegalArgumentException();
        }
    }
}
