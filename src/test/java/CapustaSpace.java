import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class CapustaSpace {
    private String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        return df.format(new Date());
    }
    @Test
    @DisplayName("регистрация нового пользователя")
    void registration() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("переходим на capusta.space " , () -> {
            open("https://stage.capusta.space/registration");
            $(".Registration_form_29bPF").shouldBe(visible);
        });
        step("указываем email", () -> {
            $("#input-email").setValue(System.currentTimeMillis()+"@capusta.space");
            $(".button").click();
        });
        step("указываем адрес проекта", () -> {
            $("#input-link").setValue("test.ru");
            $(".button").click();
        });
        step("выбираем валюту проекта", () -> {
            $(".OptionPanel_container_nUU0h").click();
        });
        step("регистрируем мерчанта", () -> {
            $(".BaseButton_button_2Jv2Z").click();
            $(".message-wrapper").shouldBe(visible);
        });
    }
}
