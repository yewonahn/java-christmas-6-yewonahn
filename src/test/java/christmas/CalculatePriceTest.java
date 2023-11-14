package christmas;

import christmas.domain.CalculatePrice;
import christmas.model.CustomerInputInfo;
import christmas.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatePriceTest {
    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 혜택 금액 구하기")
    void christmasDDayBenefit() {
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(Collections.emptyList(), 10);

        int benefit = CalculatePrice.christmasDDayBenefit(customerInputInfo);

        assertThat(benefit).isEqualTo(1000 + (10 - 1) * 100);
    }

    @Test
    @DisplayName("평일 할인 이벤트 혜택 금액 구하기")
    void weekdayBenefit() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 1), new Order("초코케이크", 2));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 1);

        int benefit = CalculatePrice.weekdayBenefit(customerInputInfo);

        assertThat(benefit).isEqualTo(2023 * 2);
    }

    @Test
    @DisplayName("주말 할인 이벤트 혜택 금액 구하기")
    void weekendBenefit() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 1), new Order("해산물파스타", 1), new Order("크리스마스파스타", 1), new Order("제로콜라", 3));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 1);

        int benefit = CalculatePrice.weekendBenefit(customerInputInfo);

        assertThat(benefit).isEqualTo(2023 * 3);
    }

    @Test
    @DisplayName("특별 할인 이벤트 혜택 금액 구하기")
    void specialDayBenefit() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 1), new Order("해산물파스타", 1), new Order("크리스마스파스타", 1), new Order("제로콜라", 3));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 25);

        int result = CalculatePrice.specialDayBenefit(customerInputInfo);

        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("증정 이벤트 혜택 금액 구하기")
    void presentBenefit() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 3), new Order("제로콜라", 3));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 25);

        int result = CalculatePrice.presentBenefit(customerInputInfo);

        assertThat(result).isEqualTo(25000);
    }

    @Test
    @DisplayName("이벤트 총 혜택 금액 구하기")
    void totalBenefit() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 1), new Order("바비큐립", 1), new Order("초코케이크", 2), new Order("제로콜라", 1));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 3);

        int result = CalculatePrice.totalBenefit(customerInputInfo);

        assertThat(result).isEqualTo(31246);
    }

    @Test
    @DisplayName("할인 후 총 결제 금액 구하기")
    void totalPaymentPriceAfterDiscount() {
        List<Order> orders = Arrays.asList(new Order("티본스테이크", 1), new Order("바비큐립", 1), new Order("초코케이크", 2), new Order("제로콜라", 1));
        CustomerInputInfo customerInputInfo = new CustomerInputInfo(orders, 3);

        int result = CalculatePrice.totalPaymentPriceAfterDiscount(customerInputInfo);

        assertThat(result).isEqualTo(135754);
    }
}
