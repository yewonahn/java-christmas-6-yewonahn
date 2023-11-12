package christmas.service;

import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

import static christmas.util.CheckValidation.*;
import static christmas.view.InputView.inputOrderMenu;

public class MakeOrders {
    public static List<Order> make (String[] pairs) {
        List<Order> orders = new ArrayList<>();
        for (String pair : pairs) {
            String[] parts = pair.split("-");
            try {
                checkMenuAmount(parts[1]);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return inputOrderMenu();
            }
            Order order = new Order(parts[0], Integer.parseInt(parts[1]));
            orders.add(order);
        }
        return orders;
    }
}
