import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    @Test
    void shouldGenerateTestDataUsingUtils() {
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");

        open("http://localhost:9999");
        $("[type='text']").setValue(info.getCity());
        $("[type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").setValue(info.getMeetingDate());
        $("[name='name']").setValue(info.getName());
        $("[name='phone']").setValue(info.getPhone());
        $("[data-test-id='agreement']").click();
        $(withText("Запланировать")).click();
        $("[data-test-id='success-notification'] .notification__content")
                .shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + info.getMeetingDate()));
        $("[type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").setValue(info.getNextDate());
        $(withText("Запланировать")).click();
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldBe(visible)
                .shouldHave(exactText("У вас уже запланирована встреча на другую дату. Перепланировать? Перепланировать"));
        $(withText("Перепланировать")).click();
        $("[data-test-id='success-notification'] .notification__content")
                .shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + info.getNextDate()));
    }
}



