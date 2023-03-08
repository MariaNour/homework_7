package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Nour");
        $("#userEmail").setValue("MN@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9377777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1994")).click();
        $(".react-datepicker__month-container").$(byText("1")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Alf.png");
        $("#currentAddress").setValue("Lipchanskogo 5, apartment 22");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Maria Nour"));
        $(".modal-body").shouldHave(text("MN@mail.ru"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9377777777"));
        $(".modal-body").shouldHave(text("01 April,1994"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Alf.png"));
        $(".modal-body").shouldHave(text("Lipchanskogo 5, apartment 22"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
       }
}