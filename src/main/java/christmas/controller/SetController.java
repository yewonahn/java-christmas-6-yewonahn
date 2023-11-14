package christmas.controller;

import christmas.model.CustomerInputInfo;
import christmas.model.EachBenefitDetail;
import christmas.service.CalculatePrice;
import christmas.service.FillBenefitsDetailList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static christmas.enums.OutputMessage.NO;
import static christmas.service.CalculatePrice.totalPaymentPriceAfterDiscount;

public class SetController {
    public static List<EachBenefitDetail> setCustomerEventInfo(CustomerInputInfo customerInputInfo) {
        List<EachBenefitDetail> benefitDetails = new ArrayList<>();
        if (customerInputInfo.checkPriceCondition()) {
            FillBenefitsDetailList.christmasDDay(benefitDetails);
            FillBenefitsDetailList.weekday(benefitDetails);
            FillBenefitsDetailList.weekend(benefitDetails);
            FillBenefitsDetailList.specialDay(benefitDetails);
            FillBenefitsDetailList.present(benefitDetails);
            return benefitDetails;
        }
        EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(NO.getOutputMessage(), 0);
        benefitDetails = new ArrayList<>(Arrays.asList(eachBenefitDetail));
        return benefitDetails;
    }
    public static int setTotalBenefitPrice(CustomerInputInfo customerInputInfo) {
        int totalBenefitPrice = CalculatePrice.totalBenefit(customerInputInfo);

        return totalBenefitPrice;
    }
    public static int setTotalPaymentPriceAfterDiscount(CustomerInputInfo customerInputInfo) {
        int totalPaymentPriceAfterDiscount = totalPaymentPriceAfterDiscount(customerInputInfo);

        return totalPaymentPriceAfterDiscount;
    }


}
