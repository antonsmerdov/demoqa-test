import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.not;



public class WebSteps {

    @Step("открытие мультисчета")
    public void openMultiBill() {
        open("https://get.stage.capusta.space/bill/733d2a6e-9de1");
        $("[data-test=billPaymentCardPaymentButton]").shouldBe(disabled);
    }
    @Test
    @Step("открытие счета")
    public void openBill() {
        open("https://capu.st/stg-bill386cfe19-1377");
        $("[data-test=billPaymentCardPaymentButton]").shouldBe(disabled);
    }

    @Step("проверка оферты")
    public void checkDownloadOfferPdf() throws Exception {
        File downloadOfferPdf = $("[data-test=billPaymentOffertaLink]").download();
        PDF pdf = new PDF(downloadOfferPdf);
        assertThat(pdf.text).isNotNull();
        assertThat(pdf.text).isNotEmpty();
    }


    @Step("проверка политики конфиденциальности")
    public void checkDownloadPrivacyPolicyPdf() throws Exception {
        File downloadPrivacyPolicyPdf = $("[data-test=billPaymentPolicyLink]").download();
        PDF pdf = new PDF(downloadPrivacyPolicyPdf);
        assertThat(pdf.text).isNotNull();
        assertThat(pdf.text).isNotEmpty();
    }

    @Step("Проверка пользовательского соглашения")
    public void checkDownloadUserAgreementPdf() throws Exception {
        File DownloadUserAgreementPdf = $("[data-test=billPaymentPolicyLink]").download();
        PDF pdf = new PDF(DownloadUserAgreementPdf);
        assertThat(pdf.text).isNotNull();
        assertThat(pdf.text).isNotEmpty();
    }
    @Test
    @Step("Выбор Английского языка")
    public void selectEnglishLanguage() {
        open("https://get.stage.capusta.space/bill/abd387f8-5556");
        $(".LocalizationController_container_7qMQz").click();
        $(".DialogTemplate_container_1bOS3").$(".SelectablingPanel_container_xSoWT", 1).click();
        $(".DialogTemplate_container_1bOS3").shouldBe(visible);
    }

    @Step("Вход в почту mail")
    public  void mailLogin() {
        open("https://e.mail.ru/inbox/?back=1");
        $("[name=username]").setValue("capusta.space");
        $(".Select__control").click();
        $(byText("@bk.ru")).click();
        $("[data-test-id=next-button]").click();
        $("[name=password]").setValue("qR-;PbSpz8!1");
        $("[data-test-id=submit-button]").click();
        sleep(3000);
    }
    @Step("Проверка открытия страницы кабинет")
    public void checkOpenCabinet() {
        $(".ProjectLogo_empty_3268j").shouldBe(visible);
        $(".statement-buttons").shouldBe(visible);
        $("#arranger").shouldBe(visible);
    }

}
