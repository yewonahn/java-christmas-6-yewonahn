package christmas.controller;

import christmas.model.Order;
import christmas.service.MakeOrders;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.CheckValidation.*;

public class InputController {
    public static int inputVisitDate() {
        String stringVisitDate = readLine();

        try {
            checkDateType(stringVisitDate);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return inputVisitDate();
        }

        int visitDate = Integer.parseInt(stringVisitDate);

        return visitDate;
    }

    public static List<Order> inputOrderMenu() {
        String[] pairs = readLine().split(",");
        List<Order> orders = MakeOrders.make(pairs);

        try {
            checkMenuValid(orders);
            checkMenuDuplication(orders);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return inputOrderMenu();
        }

        return checkConstructions(orders);
    }
}