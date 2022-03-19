import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;

public class MainContributorText {
    @CsvSource
    @Test
    void andreiSolntsevShould() {
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(Selectors.withText("Contributors"))
                .closest(".BorderGrid-row").$("ul li").hover();
        $$(".Popover-message").findBy(Condition.visible)
                .shouldHave(Condition.text("Andrei Solntsev"));
        sleep(5000);
    }
}
