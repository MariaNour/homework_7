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
                dayBirthDate = "01",
                mounthBirthDate = "April",
                yearBirthDate = "1994",
                userSubjects = "Math",
                userHobbies = "Reading",
                pictureName = "Alf.png",
                userCurrentAddress = "Lipchanskogo 5, apartment 22",
                userState = "NCR",
                userCity = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userMobileNumber)
                .setBirthDate(dayBirthDate, mounthBirthDate, yearBirthDate)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(userCurrentAddress)
                .setUserStateAndCity(userState, userCity)
                .submitBtton();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " "+ userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", " ")
                .verifyResult("Mobile", userMobileNumber)
                .verifyResult("Date of Birth", dayBirthDate +" "+ mounthBirthDate +"," + yearBirthDate)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", pictureName)
                .verifyResult("Address", userCurrentAddress)
                .verifyResult("State and City", userState + " " + userCity);

    }

}