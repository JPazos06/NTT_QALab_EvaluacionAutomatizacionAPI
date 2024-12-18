package com.nttdata.glue;

import com.nttdata.steps.PetStoreOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreOrderStepdefs {
    @Steps
    PetStoreOrderStep objSwagger;

    @Given("la url base es {string}")
    public void laUrlBaseEs(String urlBase) {
        objSwagger.obtenerUrl(urlBase);
    }

    @When("creo la orden con id {string} id de mascota {string} cantidad {string}")
    public void creoLaOrdenConIdIdDeMascotaCantidad(String idOrder, String idMascota, String cantidad) {
        objSwagger.crearOrden(idOrder, idMascota, cantidad);
    }

    @Then("Valido que el codigo de respuesta es {int}")
    public void validoQueElCodigoDeRespuestaEs(int statusCode) {
        objSwagger.validarCodigo(statusCode);
    }

    @And("valido que el estado de complecion de la orden es {string}")
    public void validoQueElEstadoDeComplecionDeLaOrdenEs(String orderComplete) {
        objSwagger.validarEstadoDeOrden(orderComplete);
    }

    @When("consulto la orden con el id {string}")
    public void consultoLaOrdenConElId(String orderId) {
        objSwagger.obtenerOrderId(orderId);
    }

    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int statusCode) {
        objSwagger.validarStatus(statusCode);
    }

    @And("valido que el status de la orden es {string}")
    public void validoQueElStatusDeLaOrdenEs(String orderStatus) {
        objSwagger.obtenerOrderStatus(orderStatus);
    }
}
