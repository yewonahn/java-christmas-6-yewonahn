package christmas.enums;

public enum BadgeState {
    SANTA("산타"),
    TREE("트리"),
    STAR("별"),
    NO("없음");

    private final String badgeState;

    BadgeState(String badgeState) {
        this.badgeState = badgeState;
    }

    public String getBadgeState() {
        return badgeState;
    }

}
