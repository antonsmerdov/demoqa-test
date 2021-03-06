import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepLessonFebruary240222 {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    @Test
    public void testIssueSearch() {


        SelenideLogger.addListener("allure", new AllureSelenide());
        step("открываем главную страницу", () -> {
            open("https://github.com");
        } );

        step("ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        } );
        step("открываем репозиторий" + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("переходим в таб Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("проверка что существует Issues с номером" + ISSUE_NUMBER, () -> {
            $(withText(String.valueOf(ISSUE_NUMBER))).should(Condition.exist);
        });

    }
}
