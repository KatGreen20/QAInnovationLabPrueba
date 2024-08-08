package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStep {

    private static final String CREATE_ORDER_URL = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden con id {0}, petId {1}, quantity {2}, shipDate {3}, status {4}, complete {5}")
    public void crearOrden(int orderId, int petId, int quantity, String shipDate, String status, boolean complete) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + orderId + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER_URL)
                .then()
                .log().all();
    }

    @Step("Validar que el campo status sea {0}")
    public void validarStatus(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
        System.out.println("Status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    @Step("Validar que el código de respuesta sea {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
