package christmas.controller;

import christmas.model.Order;
import christmas.domain.MakeOrders;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.enums.ErrorMessage.DATE_ERROR_MSG;
import static christmas.enums.ErrorMessage.ORDER_ERROR_MSG;
import static christmas.util.CheckValidation.*;

public class InputController {
    public static int inputVisitDate() {
        String stringVisitDate = readLine();

        try {
            checkDateType(stringVisitDate);
        } catch (IllegalArgumentException e) {
            System.out.println(DATE_ERROR_MSG.getErrorMessage());
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
            System.out.println(ORDER_ERROR_MSG.getErrorMessage());
            return inputOrderMenu();
        }

        return checkConstructions(orders);
    }
}