import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @Test
    @Disabled("todo: add random username generation")
    void successfulRegistrationTest() {
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/register");
        $("[data-testid=register-login-input]").setValue("user1");
        $("[data-testid=register-password-inputt]").setValue("password1");
        $("[data-testid=confirm-password-input]").setValue("password1").pressEnter();

        $("[data-testid=welcome-message]").shouldBe(text("Welcome, user1!"));

        closeWebDriver();
    }

    @Test
    void existingUserRegistrationTest() {
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/register");
        $("[data-testid=register-login-input]").setValue("user1");
        $("[data-testid=register-password-input]").setValue("password1");
        $("[data-testid=confirm-password-input]").setValue("password1").pressEnter();

        $("[data-testid=register-error-message]").shouldBe(text("Username already taken"));

        closeWebDriver();
    }
}
