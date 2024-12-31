package com.nttdata.steps.users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class CreateOrderStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void crearPedido(int orderID, int petID, int quantityOrder) {
        String body = "{\n" +
                "  \"id\": " + orderID + ",\n" +
                "  \"petId\": \"" + petID + "\",\n" +
                "  \"quantity\": \"" + quantityOrder + "\",\n" +
                "  \"shipDate\": \"2024-12-17T20:08:36.494Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": \"true\"\n" +
                "}";

        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .extract().response()
        ;
    }

    public void validarRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void verificarEstadoDelPedido(String orderStatus) {
        Assert.assertEquals("Estado del pedido: ", orderStatus, response.jsonPath().getString("status"));
    }

    public void imprimirRespuesta() {
        System.out.println(response.print());
    }
}
