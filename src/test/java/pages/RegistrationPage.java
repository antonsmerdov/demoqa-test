package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userRadioButtonGender = $(byText("Male")),
            uploadPictureInput = $("#uploadPicture"),
            userNumberInput = $("#userNumber"),
            userCheckboxHobbies = $(byText("Reading")),
            userCurrentAddress = $("#currentAddress"),
            userSubjectsInput = $("#subjectsInput"),
            userState = $("#state"),
            userCity = $("#city"),


    resultTable = $(".table-responsive");

    public void openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
    }

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    public void setRadioButtonGender() {
        userRadioButtonGender.click();
    }

    public void setCheckboxHobbies() {
        userCheckboxHobbies.click();
    }

    public void setUploadPicture(String uploadPicture) {
        uploadPictureInput.uploadFile(new File(uploadPicture));
    }

    public void setCurrentAddress(String currentAddress) {
        userCurrentAddress.setValue(currentAddress);
    }

    public void setSubjectsInput(String value, String value1) {
        userSubjectsInput.setValue(value).pressEnter()
                .setValue(value1).pressEnter();
    }

    public void setState(String state) {
        userState.$(byText(state)).click();
    }

    public void setCity(String city) {
        userCity.$(byText(city)).click();
    }

    public void checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
    }


}
