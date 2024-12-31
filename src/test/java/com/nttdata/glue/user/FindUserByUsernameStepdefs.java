package com.nttdata.glue.user;

import com.nttdata.steps.user.CreateUserStep;
import com.nttdata.steps.user.FindUserByUsernameStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FindUserByUsernameStepdefs {

    @Steps
    FindUserByUsernameStep findUserByUsernameStep;

    @Given("la URL del servicio para buscar usuario por username es {string}")
    public void laURLDelServicioParaBuscarUsuarioPorUsernameEs(String url) {
        findUserByUsernameStep.definirURL(url);
    }

    @When("busco al usuario por su username {string}")
    public void buscoAlUsuarioPorSuUsername(String usermane) {
        findUserByUsernameStep.buscarUsuarioPorUsername(usermane);
    }

    @Then("valido que el codigo de respuesta del servicio para buscar usuario por username sea {int}")
    public void validoQueElCodigoDeRespuestaDelServicioParaBuscarUsuarioPorUsernameSea(int statusCode) {
        findUserByUsernameStep.validarCodigoRespuesta(statusCode);
    }

    @And("imprimo la respuesta")
    public void imprimoLaRespuesta() {
        findUserByUsernameStep.imprimirRespuesta();
    }
}
