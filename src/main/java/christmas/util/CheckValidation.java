package christmas.util;

import christmas.enums.Menu;
import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

import static christmas.controller.InputController.inputOrderMenu;
import static christmas.enums.ErrorMessage.*;
import static christmas.domain.CheckRestrictions.maxAmountOfMenu;
import static christmas.domain.CheckRestrictions.orderOnlyDrink;

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
    public static void checkOrderForm(String[] pairs) {
        for (String pair : pairs) {
            validatePair(pair);
        }
    }
    private static void validatePair(String pair) {
        try {
            String[] parts = pair.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkMenuValid(List<Order> orders) {
        for(Order order : orders) {
            checkRightName(order.getOrderMenu());
        }
    }
    public static void checkRightName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return;
            }
        }
        throw new IllegalArgumentException();
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
            throw new IllegalArgumentException(ORDER_ERROR_MSG.getErrorMessage());
        }
    }
    public static void checkAmountOfMenuConstruction(List<Order> orders) {
        if(! maxAmountOfMenu(orders)) {
            throw new IllegalArgumentException(ORDER_ERROR_MSG.getErrorMessage());
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
