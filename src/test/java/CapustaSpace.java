import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class CapustaSpace {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1620x1080";
    }
//System.currentTimeMillis()


    //    @Disabled("без создания нового пользователя")
    @Test
    @DisplayName("регистрация нового пользователя")
    void registration() throws InterruptedException {
        WebSteps steps = new WebSteps();
        step("Переход на страницу регистрации capusta.space ", () -> {
            open("https://stage.capusta.space/registration");
            $(".Registration_form_29bPF").shouldBe(visible);
        });
        step("Ввод email", () -> {
            $(".BaseInput_input_3wdsv").setValue(getUniqueMail());
            $("button").click();
        });
        step("Ввод адреса проекта", () -> {
            $("#input-link").setValue("test.ru");
            $("button").click();
        });
        step("Выбор валюты проекта", () -> {
            $(".OptionPanel_container_nUU0h").click();
        });
        step("Регистрация мерчанта", () -> {
            $(".BaseButton_button_2Jv2Z").click();
            $(".message-wrapper").shouldBe(visible)
                    .shouldHave(text("Подтверди, что это ты"));
        });
       steps.mailLogin();
        step("Переход с письма в кабинет", () -> {
            $(".ReactVirtualized__Grid__innerScrollContainer")
                    .$(withText("Подтверждение регистрации"))
                    .click();
            $(byText("Подтвердить")).click();
            sleep(11000);
            switchTo().window(0);
            switchTo().window(1);
        });
        steps.checkOpenCabinet();
    }

    @DisplayName("Проверка трех оферт на русском языке")
    @Test
    void checkDownloadThreeOfferInRussia() throws Exception {
        WebSteps steps = new WebSteps();
        steps.openMultiBill();
        steps.checkDownloadOfferPdf();
        steps.checkDownloadPrivacyPolicyPdf();
        steps.checkDownloadUserAgreementPdf();

    }

    @DisplayName("Проверка трех оферты на английском языке")
    @Test
    void checkDownloadThreeOfferInEnglish() throws Exception {
        WebSteps steps = new WebSteps();
        steps.openBill();
        steps.selectEnglishLanguage();
        steps.checkDownloadOfferPdf();
        steps.checkDownloadPrivacyPolicyPdf();
        steps.checkDownloadUserAgreementPdf();


    }


    private String getUniqueMail() {
        return "capusta.space+" + UUID.randomUUID().toString().split("-")[0] + "@bk.ru";
    }

}
