package com.nttdata.glue.user;

import com.nttdata.steps.user.LoginUserStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginUserStepdefs {

    @Steps
    LoginUserStep loginUserStep;

    @Given("la URL del servicio para loguear usuario en el sistema es {string}")
    public void laURLDelServicioParaLoguearUsuarioEnElSistemaEs(String url) {
        loginUserStep.definirURL(url);
    }

    @When("inicio sesión con username {string} y contraseña {string}")
    public void inicioSesionConUsernameYContrasena(String username, String password) {
        loginUserStep.inicioSesion(username, password);
    }

    @And("cierro sesión de la cuenta del usuario")
    public void cierroSesionDeLaCuentaDelUsuario() {
        loginUserStep.cierroSesion();
    }

    @Then("valido el código de respuesta es {int}")
    public void validoElCodigoDeRespuestaEs(int statusCode) {
        loginUserStep.validoCodigoRespuesta(statusCode);
    }
}
