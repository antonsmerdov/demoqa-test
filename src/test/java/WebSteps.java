import com.codeborne.pdftest.PDF;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
}
