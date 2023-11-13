package christmas.service;

import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

import static christmas.enums.ErrorMessage.ORDER_ERROR_MSG;
import static christmas.util.CheckValidation.*;
import static christmas.controller.InputController.inputOrderMenu;

public class MakeOrders {
    public static List<Order> make (String[] pairs) {
        List<Order> orders = new ArrayList<>();
        for (String pair : pairs) {
            String[] parts = pair.split("-");
            try {
                checkMenuAmount(parts[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(ORDER_ERROR_MSG.getErrorMessage());
                return inputOrderMenu();
            }
            Order order = new Order(parts[0], Integer.parseInt(parts[1]));
            orders.add(order);
        }
        return orders;
    }
}
