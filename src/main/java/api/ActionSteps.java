package api;

import api.specification.RequestSpecifications;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class ActionSteps extends RequestSpecifications {
    @Step("Создание пользователя")
    public Response registrationUser(UserRegistration userRegistration) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userRegistration)
                .when()
                .post(USER_REGISTRATION);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(Credentials credentials) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(credentials)
                .when()
                .post(USER_LOGIN);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .delete(USER_BASE_URL);
    }

    @Step("Метод для шага Выход из системы")
    public Response logoutUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .post(USER_LOGOUT);
    }
}
