package com.nttdata.glue.order;

import com.nttdata.steps.order.CreateOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CreateOrderStepdefs {

    @Steps
    CreateOrderStep createOrderStep;

    @Given("la URL base del servicio es {string}")
    public void laURLBaseDelServicioEs(String url) {
        createOrderStep.definirURL(url);
    }

    @When("creo un pedido con ID {} para la mascota de ID {} de cantidad {}")
    public void creoUnPedidoConIDParaLaMascotaDeIDDeCantidad(int orderID, int petID, int quantityOrder) {
        createOrderStep.crearPedido(orderID, petID, quantityOrder);
    }

    @Then("valido que el código de respuesta es {int}")
    public void validoQueElCodigoDeRespuestaEs(int statusCode) {
        createOrderStep.validarRespuesta(statusCode);
    }

    @And("verifico que el estado del pedido sea {string}")
    public void verificoQueElEstadoDelPedidoSea(String orderStatus) {
        createOrderStep.verificarEstadoDelPedido(orderStatus);
    }


    @And("imprimo la respuesta del pedido creado en la API")
    public void imprimoLaRespuestaDelPedidoCreadoEnLaAPI() {
        createOrderStep.imprimirRespuesta();
    }
}
