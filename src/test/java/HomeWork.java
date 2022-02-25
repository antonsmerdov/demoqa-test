import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1620x1200";
    }

    @Test
    void test() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Jon");
        $("#lastName").setValue("Jonson");
        $("#userEmail").setValue("test@yandex.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("89991344444");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__year-select").selectOptionContainingText("1900");
        $(byText("30")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("/Users/anton/workspace/www.jpg"));
        $("#currentAddress").setValue("Moscow street");
        $("#subjectsInput").setValue("en").pressEnter().setValue("ma").pressEnter();
        sleep(5000);
        $("#state").scrollTo().click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Noida")).click();
        $("#city").click();
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Jon"));
    }
}
