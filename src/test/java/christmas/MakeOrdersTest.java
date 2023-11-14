package christmas;

import christmas.model.Order;
import christmas.domain.MakeOrders;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MakeOrdersTest {

    @Test
    void 사용자_입력_메뉴를_리스트에_저장() {
        String[] inputPairs = {"티본스테이크-1", "바비큐립-2", "초코케이크-3"};

        List<Order> orders = MakeOrders.make(inputPairs);

        assertThat(orders).hasSize(3);
        assertThat(orders).extracting(Order::getOrderMenu).containsExactly("티본스테이크", "바비큐립", "초코케이크");
        assertThat(orders).extracting(Order::getOrderQuantity).containsExactly(1, 2, 3);
    }
}
