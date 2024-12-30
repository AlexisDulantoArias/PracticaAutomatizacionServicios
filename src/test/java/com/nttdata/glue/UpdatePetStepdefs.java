package com.nttdata.glue;

import com.nttdata.steps.UpdatePetStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdatePetStepdefs {

    @Steps
    UpdatePetStep updatePetStep;

    @Given("la url base del servicio a modificar es {string}")
    public void laUrlBaseDelServicioAModificarEs(String url) {
        updatePetStep.definirURL(url);
    }


    @When("modifico mascota de ID {} y nombre {string} con este nuevo estado {string}")
    public void modificoMascotaDeIDYNombreConEsteNuevoEstado(int petID, String petName, String petStatus) {
        updatePetStep.modificarDatosMascota(petID, petName, petStatus);
    }

    @Then("valido el código de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        updatePetStep.validarCodigoDeRespuesta(statusCode);
    }

    @And("imprimo la modificacion de respuesta del API")
    public void imprimoLaModificacionDeRespuestaDelAPI() {
        updatePetStep.imprimoRespuestaAPI();
    }

}
