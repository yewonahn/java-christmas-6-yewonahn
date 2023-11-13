package christmas.service;

import christmas.model.EachBenefitDetail;

import java.util.List;

import static christmas.controller.ChristmasController.customerInputInfo;
import static christmas.enums.EventName.*;

public class FillBenefitsDetailList {
    public static void christmasDDay(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkChristmasDDay()) {
            int benefitPrice = CalculateBenefitAmount.christmasDDay(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(CHRISTMAS_D_DAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekday(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekday()) {
            int benefitPrice = CalculateBenefitAmount.weekday(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(WEEKDAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekend(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekend()) {
            int benefitPrice = CalculateBenefitAmount.weekend(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(WEEKEND.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void specialDay(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkSpecialDay()) {
            int benefitPrice = CalculateBenefitAmount.specialDay(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(SPECIAL_DAY.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void present(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkPresent()) {
            int benefitPrice = CalculateBenefitAmount.present(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(PRESENT.getEventName(), benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
}
