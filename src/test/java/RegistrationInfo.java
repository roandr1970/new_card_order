import lombok.Data;

//@Data
public class RegistrationInfo {
    private final String city;
    private final String meetingDate;
    private final String name;
    private final String phone;
    private final String nextDate;

    public RegistrationInfo(String city, String meetingDate, String name, String phone, String nextDate ){
        this.name = name;
        this.city = city;
        this.meetingDate = meetingDate;
        this.phone = phone;
        this.nextDate = nextDate;
    }

    public String getName() {
        return name;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getNextDate() {
        return nextDate;
    }
}
