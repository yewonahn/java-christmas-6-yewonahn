package christmas;

import christmas.enums.ErrorMessage;
import christmas.model.Order;
import christmas.util.CheckValidation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckValidationTest {

    @Test
    void 예외상황_날짜로_문자_입력() {
        assertThatThrownBy(() -> CheckValidation.checkDateType("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외상황_날짜로_범위를_초과한_숫자_입력() {
        assertThatThrownBy(() -> CheckValidation.checkDateType("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외상황_메뉴_주문_수량이_0() {
        assertThatThrownBy(() -> CheckValidation.checkMenuAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외상황_중복된_메뉴_입력() {
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("티본스테이크", 2)
        );

        assertThatThrownBy(() -> CheckValidation.checkMenuDuplication(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외상황_주문한_메뉴_개수가_20개_초과() {
        List<Order> orders = Arrays.asList(
                new Order("콜라", 1),
                new Order("티본스테이크", 21)
        );

        assertThatThrownBy(() -> CheckValidation.checkAmountOfMenuConstruction(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ORDER_ERROR_MSG.getErrorMessage());
    }

    @Test
    void 예외상황_음료만_주문() {
        List<Order> orders = Arrays.asList(
                new Order("콜라", 1)
        );

        assertThatThrownBy(() -> CheckValidation.checkDrinkConstruction(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ORDER_ERROR_MSG.getErrorMessage());
    }
    @Test
    void 예외상황_메뉴판에_없는_메뉴_주문() {
        List<Order> invalidOrders = Arrays.asList(
                new Order("메뉴판에없는메인", 2),
                new Order("메뉴판에없는디저트", 1)
        );

        assertThatThrownBy(() -> CheckValidation.checkMenuValid(invalidOrders))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 예외상황_주어진_형식과_다르게_입력() {
        String[] invalidPairs = {"티본스테이크", "크리스마스파스타_2"};

        assertThatThrownBy(() -> CheckValidation.checkOrderForm(invalidPairs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
