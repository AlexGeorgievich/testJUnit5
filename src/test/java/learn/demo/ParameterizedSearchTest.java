package learn.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedSearchTest {
    @BeforeEach
    Configuration.browser = "firefox";
    Configuration.browserSize = "1920x1080";

    void precondition(){
        open("https://ya.ru");
    }
    @AfterEach
    void closeBrowser(){
        Selenide.closeWebDriver();
    }
    @Test
    @DisplayName("Заголовок отображения поисковых результатов вяндекс для запроса Selenide")
    void searchTest () {
        // Шаги
        Selenide.$("#text").setValue("Selenide");
//        Selenide.$("button.button[type='submit'] ").click();
        Selenide.$("button[type='submit']").click();
        Selenide.$$( " ").find(text("Selenide")).shouldBe(visible);
    }
}
