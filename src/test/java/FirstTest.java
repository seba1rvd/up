import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    private static String baseUrl = "https://idemo.bspb.ru/";

    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));

    private SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));

    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080"; // Умно
    }


    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Test
    public void test() {


        loginInput.should(Condition.visible).val("demo");
        passwordInput.should(Condition.visible).val("demo");
        loginBtn.should(Condition.visible).click();


        codeInput.should(Condition.visible).val("0000");
        codeBtn.should(Condition.visible).click();
        sleep(1000);

        $("#overview").shouldHave(text("Обзор"));
        $("#accounts").shouldHave(text("Счета"));
        $("#payments").shouldHave(text("Платежи и переводы"));
        $("#cards").shouldHave(text("Карты"));
        $("#deposits").shouldHave(text("Вклады"));
        $("#loans").shouldHave(text("Кредиты"));
        $("#externaltraderoom-index").shouldHave(text("Валюта"));
        $("#insurance-travel").shouldHave(text("Страхование"));
    }

    @AfterEach
    public void after() {

    }

}
