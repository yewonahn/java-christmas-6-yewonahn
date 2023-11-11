package christmas.model;

public class EachBenefitDetail {
    private String eventName;
    private int benefitPrice;

    public EachBenefitDetail(String eventName, int benefitPrice) {
        this.eventName = eventName;
        this.benefitPrice = benefitPrice;
    }
    public String getEventName() {
        return eventName;
    }
    public int getBenefitPrice() {
        return benefitPrice;
    }
}
