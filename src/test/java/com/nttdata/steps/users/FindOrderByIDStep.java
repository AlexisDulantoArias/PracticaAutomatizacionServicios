package com.nttdata.steps.users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class FindOrderByIDStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void consultoPedidoPorID(String orderID) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("/store/order/" + orderID)
                .then()
                .log().all()
                .extract().response();
        ;
    }

    public void validarRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void verificoIDMascota(int petID) {
        int quantityFromResponse = Integer.parseInt(response.jsonPath().getString("petId"));
        Assert.assertEquals("ID de la mascota: ", petID, quantityFromResponse);
    }

    public void verificoCantidadDelPedido(int quantityOrder) {
        int quantityFromResponse = Integer.parseInt(response.jsonPath().getString("quantity"));
        Assert.assertEquals("Cantidad del Pedido: ", quantityOrder, quantityFromResponse);
    }

    public void imprimoLaRespuesta() {
        System.out.println(response.print());
    }


}
