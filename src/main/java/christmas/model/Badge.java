package christmas.model;

import christmas.service.CalculateBenefitAmount;

public class Badge {
    private String state;

    public Badge(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(int totalBenefit) {
        if (totalBenefit >= 20000) {
            state = "산타";
            return;
        }
        if (totalBenefit >= 10000) {
            state = "트리";
            return;
        }
        if (totalBenefit >= 5000) {
            state = "별";
            return;
        }
    }
}
