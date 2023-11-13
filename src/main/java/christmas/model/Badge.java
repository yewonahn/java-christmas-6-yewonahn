package christmas.model;

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
        state = "없음";
    }
}
