package christmas.view;

import christmas.Application;
import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputVisitDate() {
        String stringVisitDate = readLine();
        int visitDate = Integer.parseInt(stringVisitDate);
        return visitDate;
    }
    public static List<Order> inputOrderMenu() {
        String[] pairs = readLine().split(",");
        List<Order> orders = new ArrayList<>();
        for (String pair : pairs) {
            String[] parts = pair.split("-");
            String orderMenu = parts[0];
            int orderQuantity = Integer.parseInt(parts[1]);

            Order order = new Order(orderMenu, orderQuantity);
            orders.add(order);
        }
        return orders;
    }
}