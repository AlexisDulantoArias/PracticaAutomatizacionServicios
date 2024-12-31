package com.nttdata.steps.order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class InventoryByStatusStep {

    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void consultarInventario() {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("/store/inventory")
                .then()
                .log().all()
                .extract().response();
        ;
    }

    public void validarRespuesta(int statusCode) {
        Assert.assertEquals("Validación de respuesta", statusCode, response.statusCode());
    }

    public void imprimoLaRespuesta() {
        System.out.println(response.print());
    }
}
