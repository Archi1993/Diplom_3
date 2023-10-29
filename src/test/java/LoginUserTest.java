import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import page.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginUserTest extends BaseActions{

    @Before
    public void registrationUser() {
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void checkLoginOnEnterAccountButton() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа по кнопке «Личный кабинет»")
    public void checkLoginOnClickPersonalAccountButton() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку на форме регистрации")
    @Description("Проверка входа по кнопке на форме регистрации")
    public void checkLoginOnClickEnterButtonOnRegistrationPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.clickSignInButton();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoginOnForgotPasswordPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRestorePasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.clickOnTheRememberPasswordLink();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта")
    public void checkExitFromProfile() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.clickOnExitButton();
        Assert.assertTrue(getDriver().findElement(loginPage.getEnterHeader()).isDisplayed());
    }
}
