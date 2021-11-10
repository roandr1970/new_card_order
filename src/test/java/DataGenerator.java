import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    public  static class Registration {

        public static RegistrationInfo generateInfo (String locale) {
            Faker faker = new Faker(new Locale(locale));
            String meetingDate = DateGenerator.generateDate(3);
            String nextDate = DateGenerator.generateDate(5);
            return new RegistrationInfo(faker.address().cityName(), meetingDate, faker.name().name(), faker.phoneNumber().subscriberNumber(11), nextDate);
        }
    }
}
