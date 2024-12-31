package com.nttdata.glue.order;

import com.nttdata.steps.order.FindOrderByIDStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FindOrderByIDStepdefs {

    @Steps
    FindOrderByIDStep findOrderByIDStep;

    @Given("la URL base del servicio para consultar el pedido por ID es {string}")
    public void laURLBaseDelServicioParaConsultarElPedidoPorIDEs(String url) {
        findOrderByIDStep.definirURL(url);
    }

    @When("consulto el ID del pedido {}")
    public void consultoElIDDelPedido(String orderID) {
        findOrderByIDStep.consultoPedidoPorID(orderID);
    }

    @Then("valido que el código de respuesta sea {int} para el servicio")
    public void validoQueElCodigoDeRespuestaSeaParaElServicio(int statusCode) {
        findOrderByIDStep.validarRespuesta(statusCode);
    }

    @And("verifico el id de la mascota {}")
    public void verificoElIdDeLaMascota(int petID) {
        findOrderByIDStep.verificoIDMascota(petID);
    }

    @And("verifico la cantidad del pedido {}")
    public void verificoLaCantidadDelPedido(int quantityOrder) {
        findOrderByIDStep.verificoCantidadDelPedido(quantityOrder);
    }

    @And("la respuesta debe tener todos los datos de la orden")
    public void laRespuestaDebeTenerTodosLosDatosDeLaOrden() {
        findOrderByIDStep.imprimoLaRespuesta();
    }

}
