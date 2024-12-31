package com.nttdata.glue.order;

import com.nttdata.steps.order.InventoryByStatusStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InventoryByStatusStepdefs {

    @Steps
    InventoryByStatusStep inventoryByStatusStep;

    @Given("la URL base para verificar los inventarios es {string}")
    public void laURLBaseParaVerificarLosInventariosEs(String url) {
        inventoryByStatusStep.definirURL(url);
    }

    @When("consulto el inventario")
    public void consultoElInventario() {
        inventoryByStatusStep.consultarInventario();
    }

    @Then("valido que el código de respuesta para el servicio sea {int}")
    public void validoQueElCodigoDeRespuestaParaElServicioSea(int statusCode) {
        inventoryByStatusStep.validarRespuesta(statusCode);
    }

    @And("imprimo la respuesta del servicio")
    public void imprimoLaRespuestaDelServicio() {
        inventoryByStatusStep.imprimoLaRespuesta();
    }
}
