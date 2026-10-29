import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @Test
    void successfulLoginTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text("Welcome, user1!"));

        closeWebDriver();
    }

    @Test
    void wrongPasswordTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password2").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Wrong login or password"));

        closeWebDriver();
    }

    @Test
    void missingPasswordTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("user1").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Password is required (minimum 6 characters)"));

        closeWebDriver();
    }
}
