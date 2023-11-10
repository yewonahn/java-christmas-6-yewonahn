package christmas.model;

public class CustomerInputInform {
    private final String orderMenu;
    private final int orderQuantity;
    private final int visitDate;

    public CustomerInputInform(String orderMenu, int orderQuantity, int visitDate) {
        this.orderMenu = orderMenu;
        this.orderQuantity = orderQuantity;
        this.visitDate = visitDate;
    }
}