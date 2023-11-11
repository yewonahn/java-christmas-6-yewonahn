package christmas.enums;

public enum Menu {

    SOUP("양송이수프", 6000, "<애피타이저>"),
    TAPAS("타파스", 5500, "<애피타이저>"),
    CAESAR_SALAD("시저샐러드", 8000, "<애피타이저>"),
    T_BONE_STEAK("티본스테이크", 55000, "<메인>"),
    BBQ_RIBS("바비큐립", 54000, "<메인>"),
    SEAFOOD_PASTA("해산물파스타", 35000, "<메인>"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "<메인>"),
    CHOCOLATE_CAKE("초코케이크", 15000, "<디저트>"),
    ICE_CREAM("아이스크림", 5000, "<디저트>"),
    ZERO_COLA("제로콜라", 3000, "<음료>"),
    RED_WINE("레드와인", 60000, "<음료>"),
    CHAMPAGNE("샴페인", 25000, "<음료>");

    private final String name;
    private final int price;
    private final String category;

    Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public static int getPriceByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        // 이름에 해당하는 메뉴가 없을 경우 예외처리 또는 기본값 반환
        throw new IllegalArgumentException("Invalid menu name: " + name);
    }
    public static String getCategoryByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu.getCategory();
            }
        }
        // 이름에 해당하는 카테고리가 없을 경우 예외처리 또는 기본값 반환
        throw new IllegalArgumentException("Invalid menu name: " + name);
    }
}
