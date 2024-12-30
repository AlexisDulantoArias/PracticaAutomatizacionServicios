package com.nttdata.steps.pets;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class UpdatePetStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void modificarDatosMascota(int petID, String petStatus, String petName) {
        String body = "{\n" +
                "  \"id\": " + petID + ",\n" +
                "  \"name\": \"" + petName + "\",\n" +
                "  \"status\": \"" + petStatus + "\"\n" +
                "}";

        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .put("/pet")
                .then()
                .extract().response()
        ;
    }

    public void validarCodigoDeRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void imprimoRespuestaAPI() {
        System.out.println(response.print());
    }
}
