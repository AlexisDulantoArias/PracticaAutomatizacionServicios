package com.nttdata.glue;

import com.nttdata.steps.FindPetStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FindPetStepdefs {

    @Steps
    FindPetStep findPetStep;

    @Given("la url base del servicio para encontrar mascota es {string}")
    public void laUrlBaseDelServicioParaEncontrarMascotaEs(String url) {
        findPetStep.definirURL(url);
    }

    @When("busco a mascota por ID {}")
    public void buscoAMascotaPorID(int petID) {
        findPetStep.buscarMascotaPorID(petID);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        findPetStep.validarCodigoDeRespuesta(statusCode);
    }

    @And("imprimo la respuesta de la API")
    public void imprimoLaRespuestaDeLaAPI() {
        findPetStep.imprimoRespuesta();
    }
}
