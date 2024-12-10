import jakarta.xml.bind.annotation.XmlElement;

public class ValidPeriod {
    private String startOfPeriod;
    private String endOfPeriod;
    private RecurringTimePeriodOfDay recurringTimePeriodOfDay;
    private RecurringDayWeekMonthPeriod recurringDayWeekMonthPeriod;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getStartOfPeriod() {
        return startOfPeriod;
    }

    public void setStartOfPeriod(String startOfPeriod) {
        this.startOfPeriod = startOfPeriod;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getEndOfPeriod() {
        return endOfPeriod;
    }

    public void setEndOfPeriod(String endOfPeriod) {
        this.endOfPeriod = endOfPeriod;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public RecurringTimePeriodOfDay getRecurringTimePeriodOfDay() {
        return recurringTimePeriodOfDay;
    }

    public void setRecurringTimePeriodOfDay(RecurringTimePeriodOfDay recurringTimePeriodOfDay) {
        this.recurringTimePeriodOfDay = recurringTimePeriodOfDay;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public RecurringDayWeekMonthPeriod getRecurringDayWeekMonthPeriod() {
        return recurringDayWeekMonthPeriod;
    }

    public void setRecurringDayWeekMonthPeriod(RecurringDayWeekMonthPeriod recurringDayWeekMonthPeriod) {
        this.recurringDayWeekMonthPeriod = recurringDayWeekMonthPeriod;
    }
}
