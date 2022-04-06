import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.not;

public class WebSteps {
    @Step("проверка загрузки оферты")
    public void checkDownloadOfferPdf() throws Exception {
        File downloadOfferPdf = $(".policy-privacy").$("[target=_blank]",0).download();
        PDF pdf = new PDF(downloadOfferPdf);
        assertThat(pdf.text).isNotNull();
        assertThat(pdf.text).isNotEmpty();
    }
    @Step("проверка загрузки политики конфиденциальности")
    public void checkDownloadPrivacyPolicyPdf() throws Exception {
        File downloadPrivacyPolicyPdf = $(".policy-privacy").$("[target=_blank]",1).download();
        PDF pdf = new PDF(downloadPrivacyPolicyPdf);
        assertThat(pdf.text).isNotNull();
        assertThat(pdf.text).isNotEmpty();
    }
//    @Step("выбор Английского языка")
    @Test
    public void selectEnglishLanguage() {
        open("https://get.stage.capusta.space/bill/abd387f8-5556");
        $(".LocalizationController_container_7qMQz").click();
        $(".DialogTemplate_container_1bOS3").$(".SelectablingPanel_container_xSoWT", 1).click();
        $(".DialogTemplate_container_1bOS3").shouldBe(hidden);
    }

}
