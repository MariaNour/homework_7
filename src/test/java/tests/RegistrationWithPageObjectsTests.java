package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String  userName = "Maria",
                userLastName = "Nour",
                userEmail = "MN@mail.ru",
                userGender = "Female",
                userMobileNumber = "9377777777",
                day = "01",
                mounth = "April",
                year = "1994";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userMobileNumber)
                .setBirthDate(day, mounth, year);

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/Alf.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " "+ userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userMobileNumber)
                .verifyResult("Date of Birth", day +" "+ mounth +","+ year);
//        registrationPage.registrationResultsModal.verifyResult("Student Name", userName + " Egorov");
    }

}