package christmas.model;

public class EachBenefitDetail {
    private final String eventName;
    private final int benefitPrice;

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
