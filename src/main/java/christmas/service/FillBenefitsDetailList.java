package christmas.service;

import christmas.domain.CalculatePrice;
import christmas.model.CustomerInputInfo;
import christmas.model.EachBenefitDetail;

import java.util.List;

import static christmas.enums.EventName.*;

public class FillBenefitsDetailList {
    public static void christmasDDay(CustomerInputInfo customerInputInfo, List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkChristmasDDay()) {
            int benefitPrice = CalculatePrice.christmasDDayBenefit(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(CHRISTMAS_D_DAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekday(CustomerInputInfo customerInputInfo, List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekday()) {
            int benefitPrice = CalculatePrice.weekdayBenefit(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(WEEKDAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekend(CustomerInputInfo customerInputInfo, List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekend()) {
            int benefitPrice = CalculatePrice.weekendBenefit(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(WEEKEND.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void specialDay(CustomerInputInfo customerInputInfo, List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkSpecialDay()) {
            int benefitPrice = CalculatePrice.specialDayBenefit(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(SPECIAL_DAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void present(CustomerInputInfo customerInputInfo, List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkPresent()) {
            int benefitPrice = CalculatePrice.presentBenefit(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(PRESENT.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
}
