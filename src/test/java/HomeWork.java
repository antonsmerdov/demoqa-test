import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class HomeWork {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1620x1400";
    }

    @Test
    void test() {
        registrationPage.openPage();
        registrationPage.setFirstName("Jon");
        registrationPage.setLastName("Jonson");
        registrationPage.setUserEmail("test@yandex.ru");
        registrationPage.setRadioButtonGender();
        registrationPage.setUserNumber("89991344444");
        registrationPage.setBirthDate("30", "March", "1900");
        registrationPage.setCheckboxHobbies();
        registrationPage.setUploadPicture("/Users/anton/workspace/www.jpg");
        registrationPage.setCurrentAddress("Moscow street");
        registrationPage.setSubjectsInput("en", "ma");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        registrationPage.setState("NCR");
        $("#city").click();
        registrationPage.setCity("Delhi");
        $("#city").click();
        $("#state").click();
        $("#submit").click();
        registrationPage.checkForm("Student Name", "Jon Jonson");

    }
}
