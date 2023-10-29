import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import page.LoginPage;
import page.MainPage;
import page.RegisterPage;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationUserTest extends BaseActions {
    @Test
    @DisplayName("Регистрация нового пользователя")
    @Description("Проверка регистрации нового пользователя")
    public void checkRegistrationNewUser() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registrationNewUser(getName(), getEmail(), getPassword());
        Assert.assertTrue(getDriver().findElement(loginPage.getEnterHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Получение ошибки для некорректного пароля")
    @Description("Ошибка для некорректного пароля при задании пароля менее 6 символов")
    public void checkRegistrationUserWithIncorrectPassword() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnButtonPersonalAccount();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registrationNewUser(getName(), getEmail(), getIncorrectPassword());
        Assert.assertTrue(getDriver().findElement(registerPage.getIncorrectPassword()).isDisplayed());
    }
}