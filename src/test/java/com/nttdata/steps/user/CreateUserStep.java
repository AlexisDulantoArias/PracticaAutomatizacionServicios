package com.nttdata.steps.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class CreateUserStep {

    Response response;
    private String URL_BASE;

    public void definoLaURL(String url) {
        URL_BASE = url;
    }

    public void crearDatosUsuario(String username, String firstName, String lastName, String password) {
        String body = "{\n" +
                "  \"id\": " + 0 + ",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": " + 0 + "\n" +
                "}";

        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/user")
                .then()
                .extract().response()
        ;
    }

    public void validarCodigoRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }
}
