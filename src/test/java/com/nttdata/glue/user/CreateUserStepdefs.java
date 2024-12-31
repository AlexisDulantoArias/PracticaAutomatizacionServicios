package com.nttdata.glue.user;

import com.nttdata.steps.user.CreateUserStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CreateUserStepdefs {

    @Steps
    CreateUserStep createUserStep;

    @Given("la URL del servicio para crear el usuario es {string}")
    public void laURLDelServicioParaCrearElUsuarioEs(String url) {
        createUserStep.definoLaURL(url);
    }

    @When("creo un usuario con nombre de usuario {string}, primer nombre{string}, apellidos {string}, contraseña {string}")
    public void creoUnUsuarioConNombreDeUsuarioPrimerNombreApellidosContrasena(String username, String firstName, String lastName, String password) {
        createUserStep.crearDatosUsuario(username, firstName, lastName, password);
    }

    @Then("valido que el codigo de respuesta del servicio sea {int}")
    public void validoQueElCodigoDeRespuestaDelServicioSea(int statusCode) {
        createUserStep.validarCodigoRespuesta(statusCode);
    }
}
