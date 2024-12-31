package com.nttdata.steps.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class LoginUserStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void inicioSesion(String username, String password) {
        if (URL_BASE == null || URL_BASE.isEmpty()) {
            throw new IllegalStateException("La URL base no está configurada.");
        }

        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .queryParam("username", username)
                .queryParam("password", password)
                .relaxedHTTPSValidation()
                .log().all()
                .get("/user/login")
                .then()
                .extract().response();
    }

    public void cierroSesion() {
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .get("/user/logout")
                .then()
                .extract().response();
    }

    public void validoCodigoRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }
}
