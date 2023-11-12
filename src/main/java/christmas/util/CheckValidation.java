package christmas.util;

import christmas.enums.Menu;
import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static christmas.view.InputView.inputOrderMenu;

public class CheckValidation {
    public void checkDateType(String stringVisitDate) {
        if (Integer.parseInt(stringVisitDate) < 1 || Integer.parseInt(stringVisitDate) > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
    public List<Order> checkInputOrderMenu(List<Order> orders) {
        try {
            checkMenuValid(orders);
            checkMenuAmount(orders);
            checkMenuDuplication(orders);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputOrderMenu();
        }
        return orders;
    }
    public void checkMenuValid(List<Order> orders) {
        for (Order order : orders) {
            if(! Menu.checkRightName(order.getOrderMenu())) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    public void checkMenuAmount(List<Order> orders) {
        for (Order order : orders) {
            if (order.getOrderQuantity() < 1 || order.getOrderQuantity() > 20) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    public void checkMenuDuplication(List<Order> orders) {
        List<String> menuNames = new ArrayList<>();
        for(Order order : orders) {
            menuNames.add(order.getOrderMenu());
        }
        List<String> duplicationTest = new ArrayList<>();
        duplicationTest = menuNames.stream().distinct().collect(Collectors.toList());
        if (menuNames.size() != duplicationTest.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
