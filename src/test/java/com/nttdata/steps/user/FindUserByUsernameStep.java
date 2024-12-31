package com.nttdata.steps.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class FindUserByUsernameStep {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void buscarUsuarioPorUsername(String usermane) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("/user/" + usermane)
                .then()
                .log().all()
                .extract().response();
        ;
    }

    public void validarCodigoRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void imprimirRespuesta() {
        System.out.println(response.print());
    }
}
