package christmas.model;

import christmas.enums.Menu;

public class Order {
    private final String orderMenu;
    private final int orderQuantity;

    public Order (String orderMenu, int orderQuantity) {
        this.orderMenu = orderMenu;
        this.orderQuantity = orderQuantity;
    }
    public String getOrderMenu() {
        return orderMenu;
    }
    public int getOrderQuantity() {
        return orderQuantity;
    }
    public int getEachMenuTotalPrice() {
        int menuPrice = Menu.getPriceByName(orderMenu);
        int eachMenuTotalPrice = menuPrice * orderQuantity;
        return eachMenuTotalPrice;
    }
    public String getCategory() {
        String category = Menu.getCategoryByName(orderMenu);
        return category;
    }
}
