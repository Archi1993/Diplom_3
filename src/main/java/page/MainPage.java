package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By enterInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By constructBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By logoStellarBurgers = By.xpath(".//div/header/nav/div/a");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By ingredientsTab = By.xpath(".//span[text()='Начинки']");
    private final By сhosenElement = By.className("tab_tab_type_current__2BEPc");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Личный Кабинет")
    public void clickOnButtonPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по кнопке входа в аккаунт")
    public void clickOnEnterButton() {
        driver.findElement(enterInAccountButton).click();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickOnLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    @Step("Клик по вкладке Булки")
    public void clickOnBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Клик по вкладке Соусы")
    public void clickOnSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Клик по вкладке Начинки")
    public void clickOnIngredientsTab() {
        driver.findElement(ingredientsTab).click();
    }

    @Step("Получить текст элемента")
    public String getTextFromChosenElement() {
        return driver.findElement(сhosenElement).getText();
    }

    @Step("Получение заголовка Соберите бургер")
    public By getConstructBurgerHeader() {
        return constructBurgerHeader;
    }
}