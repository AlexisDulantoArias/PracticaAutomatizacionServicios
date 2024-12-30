package com.nttdata.glue.pets;

import com.nttdata.steps.pets.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {

    @Steps
    PetStoreStep petStoreStep;

    @Given("la url base del servicio es {string}")
    public void laUrlBaseDelServicioEs(String url) {
        petStoreStep.definirURL(url);
    }

    @When("creo una mascota con el ID {} con nombre {string} y de estado {string}")
    public void creoUnaMascotaConElIDConNombreYDeEstado(int petID, String petName, String petStatus) {
        petStoreStep.crearMascota(petID, petName, petStatus);
    }

    @Then("valido que el código de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int statusCode) {
        petStoreStep.validarStatus(statusCode);
    }

    @And("verifico que el estado de la mascota sea {string}")
    public void verificoQueElEstadoDelPedidoSea(String petStatus) {
        petStoreStep.verificarEstadoPedido(petStatus);
    }

    @And("imprimo la respuesta del API")
    public void imprimoLaRespuestaDelAPI() {
        petStoreStep.imprimirRespuesta();
    }
}
