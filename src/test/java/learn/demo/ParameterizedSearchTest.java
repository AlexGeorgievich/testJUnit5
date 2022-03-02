package learn.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedSearchTest {

    @BeforeEach
    void precondition() {
//        Configuration.browser ="firefox";
//        Configuration.browserSize ="1920x1080";
        open("https://ya.ru");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
/*
    @Test
    @DisplayName("Заголовок отображения поисковых результатов в яндекс для запроса Selenide")
    void searchTest() {
        // Шаги
        Selenide.$("#text").setValue("Selenide");
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").find(text("Selenide")).shouldBe(visible);
    }

    @Test
    @DisplayName("Заголовок отображения поисковых результатов в яндекс для запроса JUnit5")
    void searchJUnit5Test() {
        // Шаги
        Selenide.$("#text").setValue("JUnit5");
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").find(text("JUnit5")).shouldBe(visible);
    }

    @ValueSource(strings = {"Selenide", "JUnit5"})
    @ParameterizedTest(name = " Проверка наличия в поиске запроса в Ян \"{0}\"")
    void commonSearchTest(String testData) {
        // Шаги
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").find(text(testData)).shouldBe(visible);
    }

*/
    @CsvSource({
            "Selenide,: Concise UI tests in Java",
            "JUnit5,The IntelliJ IDEA Blog"
        })
    @ParameterizedTest(name = " Проверка наличия в поиске запроса в Ян \"{0}\"")
    void commonSearchTest(String testData, String expectedText) {
        // Шаги
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").find(text(expectedText)).shouldBe(visible);
    }

}
