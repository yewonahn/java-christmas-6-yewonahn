package christmas.util;

import christmas.enums.Menu;
import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

import static christmas.controller.InputController.inputOrderMenu;
import static christmas.util.CheckRestrictions.maxAmountOfMenu;
import static christmas.util.CheckRestrictions.orderOnlyDrink;

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
    public static void checkDrinkConstruction(List<Order> orders) {
        if(! orderOnlyDrink(orders)) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");
        }
    }
    public static void checkAmountOfMenuConstruction(List<Order> orders) {
        if(! maxAmountOfMenu(orders)) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
        }
    }
    public static List<Order> checkConstructions(List<Order> orders) {
        try {
            checkDrinkConstruction(orders);
            checkAmountOfMenuConstruction(orders);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputOrderMenu();
        }
        return orders;
    }
}
