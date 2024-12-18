package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreOrderStep {
    Response response;
    private String URL_BASE;
    private String ID_ORDER;
    private String ID_MASCOTA;

    public void obtenerUrl(String urlBase) {
        URL_BASE = urlBase;
    }

    public void crearOrden(String idOrder, String idMascota, String cantidad) {
        String body = "{\n" +
                "  \"id\": " + idOrder + ",\n" +
                "  \"petId\": " + idMascota + ",\n" +
                "  \"quantity\": " + cantidad + ",\n" +
                "  \"shipDate\": \"2024-12-18T01:05:34.375Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .post("/store/order/")
                .then()
                .extract().response()
        ;
    }

    public void validarCodigo(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta", statusCode, response.statusCode());
    }

    public void validarEstadoDeOrden(String orderComplete) {
        String estadoComplecion = response.jsonPath().getString("complete");
        Assert.assertEquals("Validación del estado de la orden", orderComplete, estadoComplecion);
    }

    public void obtenerOrderId(String orderId) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .get("/store/order/" + orderId)
                .then()
                .log().all()
                .extract().response()
        ;
    }

    public void validarStatus(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta", statusCode, response.statusCode());
    }

    public void obtenerOrderStatus(String orderStatus) {
        String estadoOrden = response.jsonPath().getString("status");
        Assert.assertEquals("Validación del estado de la orden", orderStatus, estadoOrden);
    }
}
