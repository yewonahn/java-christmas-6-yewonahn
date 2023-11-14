package christmas.controller;

import christmas.model.EachBenefitDetail;
import christmas.domain.CalculatePrice;
import christmas.service.FillBenefitsDetailList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static christmas.controller.ChristmasController.customerInputInfo;
import static christmas.enums.OutputMessage.NO;
import static christmas.domain.CalculatePrice.totalPaymentPriceAfterDiscount;

public class SetController {
    public static List<EachBenefitDetail> setCustomerEventInfo() {
        List<EachBenefitDetail> benefitDetails = new ArrayList<>();
        if (customerInputInfo.checkPriceCondition()) {
            FillBenefitsDetailList.christmasDDay(customerInputInfo, benefitDetails);
            FillBenefitsDetailList.weekday(customerInputInfo, benefitDetails);
            FillBenefitsDetailList.weekend(customerInputInfo, benefitDetails);
            FillBenefitsDetailList.specialDay(customerInputInfo, benefitDetails);
            FillBenefitsDetailList.present(customerInputInfo, benefitDetails);
            return benefitDetails;
        }
        EachBenefitDetail eachBenefitDetail = new EachBenefitDetail(NO.getOutputMessage(), 0);
        benefitDetails = new ArrayList<>(Arrays.asList(eachBenefitDetail));
        return benefitDetails;
    }
    public static int setTotalBenefitPrice() {
        int totalBenefitPrice = CalculatePrice.totalBenefit(customerInputInfo);

        return totalBenefitPrice;
    }
    public static int setTotalPaymentPriceAfterDiscount() {
        int totalPaymentPriceAfterDiscount = totalPaymentPriceAfterDiscount(customerInputInfo);

        return totalPaymentPriceAfterDiscount;
    }


}
