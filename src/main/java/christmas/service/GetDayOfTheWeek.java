package christmas.service;

public class GetDayOfTheWeek {
    public static String getDayOfTheWeek(int visitDate) {
        if(visitDate % 7 == 1 || visitDate % 7 == 2) {
            return "weekend";
        }
        return "weekday";
    }
}
