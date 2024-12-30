package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreStep {

    Response response;
    private String URL_BASE;


    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void crearMascota(int petID, String petName, String petStatus) {
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
                .post("/pet")
                .then()
                .extract().response()
        ;
    }

    public void validarStatus(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void verificarEstadoPedido(String petStatus) {
        Assert.assertEquals("Estado del pedido: ", petStatus, response.jsonPath().getString("status"));
    }


    public void imprimirRespuesta() {
        System.out.println(response.print());
    }
}
