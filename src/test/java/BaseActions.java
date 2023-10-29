import io.restassured.RestAssured;
import io.restassured.response.Response;
import api.Credentials;
import api.UserRegistration;
import api.ActionSteps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static browser.SetupBrowser.*;

public class BaseActions {
    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final String email = "test-Archi4@yandex.ru";
    private final String password = "password123";
    private final String name = "Archi";
    private final String incorrectPassword = "1234";
    private WebDriver driver;
    private final ActionSteps actionSteps = new ActionSteps();
    private final UserRegistration userRegistration = new UserRegistration(email, password, name);
    private final Credentials credentials = new Credentials(email, password);
    private final Credentials incorrectPasswordCredentials = new Credentials(email, incorrectPassword);

    public void setDriver() {
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(MAIN_PAGE);
        driver.manage().window().maximize();
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = MAIN_PAGE;
        setDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ActionSteps getUser() {
        return actionSteps;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Credentials getUserLogin() {
        return credentials;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

    public Credentials getLoginIncorrectUser() {
        return incorrectPasswordCredentials;
    }

    @After
    public void cleanUp() {
        Response response = getUser().loginUser(getUserLogin());
        if (response.jsonPath().get("success").equals(true)) {
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        response = getUser().loginUser(getLoginIncorrectUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }

}