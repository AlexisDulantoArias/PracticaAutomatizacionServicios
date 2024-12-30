package com.nttdata.steps.pets;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class FindPetStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void buscarMascotaPorID(int petID) {
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get("/pet/"+ petID)
                .then()
                .extract().response()
        ;
    }

    public void validarCodigoDeRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void imprimoRespuesta() {
        System.out.println(response.print());
    }
}
