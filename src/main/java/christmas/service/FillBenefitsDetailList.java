package christmas.service;

import christmas.model.EachBenefitDetail;

import java.util.List;

import static christmas.Application.customerInputInfo;

public class FillBenefitsDetailList {
    public static void christmasDDay(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkChristmasDDay()) {
            int benefitPrice = CalculateBenefitAmount.christmasDDay(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail("크리스마스 디데이 할인", benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekday(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekday()) {
            int benefitPrice = CalculateBenefitAmount.weekday(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail("평일 할인", benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void weekend(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkWeekend()) {
            int benefitPrice = CalculateBenefitAmount.weekend(customerInputInfo);
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail("주말 할인", benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void specialDay(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkSpecialDay()) {
            int benefitPrice = CalculateBenefitAmount.specialDay();
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail("특별 할인", benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
    public static void present(List<EachBenefitDetail> benefitDetails) {
        if(customerInputInfo.checkPresent()) {
            int benefitPrice = CalculateBenefitAmount.present();
            EachBenefitDetail eachBenefitDetail = new EachBenefitDetail("증정 이벤트", benefitPrice);
            benefitDetails.add(eachBenefitDetail);
        }
    }
}
