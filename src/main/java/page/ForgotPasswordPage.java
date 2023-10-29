package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    private final By clickOnTheRememberPasswordLink = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход по ссылке Вспомнили пароль?")
    public void clickOnTheRememberPasswordLink() {
        driver.findElement(clickOnTheRememberPasswordLink).click();
    }
}