package christmas.model;

import static christmas.enums.BadgeState.*;

public class Badge {
    private String state;

    public Badge(int totalBenefit) {
        setState(totalBenefit);
    }
    public String getState() {
        return state;
    }

    public void setState(int totalBenefit) {
        if (totalBenefit >= 20000) {
            state = SANTA.getBadgeState();
            return;
        }
        if (totalBenefit >= 10000) {
            state = TREE.getBadgeState();
            return;
        }
        if (totalBenefit >= 5000) {
            state = STAR.getBadgeState();
            return;
        }
        state = NO.getBadgeState();
    }
}
