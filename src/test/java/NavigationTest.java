import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import page.LoginPage;
import page.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.ProfilePage;

public class NavigationTest extends BaseActions {
    @Before
    public void registrationUser() {
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void checkMoveToProfilePageFromMainPageRegisteredUser() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkMoveToConstructorFromProfileOnConstructorButton() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnConstructorButton();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void checkMoveToConstructorFromProfileOnStellarBurgerLogo() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        mainPage.clickOnLogoStellarBurgers();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Работа перехода на закладку «Булки»")
    @Description("Работа перехода на закладку «Булки» c других закладок")
    public void checkMovingBetweenTabsIngredientsAndBuns() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsTab();
        mainPage.clickOnBunsTab();
        Assert.assertEquals("Некорретная закладка! Должен быть переход на закладку Булки", "Булки", mainPage.getTextFromChosenElement()); // проверяет текст через метод assertEquals
    }

    @Test
    @DisplayName("Работа перехода на раздел «Соусы»")
    @Description("Работа перехода на закладку «Соусы» c других закладок")
    public void checkMovingBetweenChaptersIngredientsAndSauces() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsTab();
        mainPage.clickOnSaucesTab();
        Assert.assertEquals("Некорретная закладка! Должен быть переход на закладку Соусы", "Соусы", mainPage.getTextFromChosenElement()); // проверяет текст через метод assertEquals
    }

    @Test
    @DisplayName("Работа перехода на раздел «Начинки»")
    @Description("Работа перехода на закладку «Начинки» c других закладок")
    public void checkMovingBetweenChaptersSaucesAndIngredients() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesTab();
        mainPage.clickOnIngredientsTab();
        Assert.assertEquals("Некорретная закладка! Должен быть переход на закладку Начинки", "Начинки", mainPage.getTextFromChosenElement()); // проверяет текст через метод assertEquals
    }

}