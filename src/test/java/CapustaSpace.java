import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.WebSteps;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class CapustaSpace {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1620x1080";
    }

    private String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHH");
        return df.format(new Date());
    }
    @Disabled("без создания нового пользователя")
    @Test
    @DisplayName("регистрация нового пользователя")
    void registration() {
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
    @DisplayName("Загрузка оферты на русском языке")
    @Test
    void checkDownloadThreeOfferInRussia() throws Exception {
        WebSteps steps = new WebSteps();
        step("открываем счет ",() -> {
            open("https://get.stage.capusta.space/bill/abd387f8-5556");
        });
        steps.checkDownloadOffer();
        steps.checkDownloadPrivacyPolicy();

    }
    @DisplayName("Загрузка оферты на английском языке")
    @Test
    void checkDownloadThreeOfferInEnglish() throws Exception {
        WebSteps steps = new WebSteps();
        step("открываем счет ",() -> {
            open("https://get.stage.capusta.space/bill/abd387f8-5556");
        });
        steps.setEnglishLanguage();
        sleep(5000);
        steps.checkDownloadOffer();
        steps.checkDownloadPrivacyPolicy();

    }


}
