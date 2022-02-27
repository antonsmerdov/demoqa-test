import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class HomeWork {

    RegistrationPage RegistrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void test() {
        RegistrationPage.openPage();
        RegistrationPage.setFirstName("Jon");
        RegistrationPage.setLastName("Jonson");
        RegistrationPage.setUserEmail("test@yandex.ru");
        RegistrationPage.setRadioButtonGender();
        RegistrationPage.setUserNumber("89991344444");
        RegistrationPage.setBirthDate("30", "March", "1900");
        RegistrationPage.setCheckboxHobbies();
        RegistrationPage.setUploadPicture("/Users/anton/workspace/www.jpg");
        RegistrationPage.setCurrentAddress("Moscow street");
        RegistrationPage.setSubjectsInput("en", "ma");
        $("#state").scrollTo().click();
        RegistrationPage.setState("NCR");
        $("#city").click();
        RegistrationPage.setCity("Noida");
        $("#city").click();
        $("#submit").click();
        RegistrationPage.checkForm("Student Name", "Jon Jonson");

    }
}
