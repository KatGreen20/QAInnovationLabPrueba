package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class ObtenerOrdenStep {

    @Step("Consultar orden con ID {0}")
    public void consultarOrden(int orderId) {
        SerenityRest.given()
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/" + orderId)
                .then()
                .log().all(); // Opcional, para ver detalles en los logs
    }

    @Step("Validar que el código de respuesta sea {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Validar que el campo {0} sea {1}")
    public void validarCampo(String field, Object expectedValue) {
        restAssuredThat(response -> response.body(field, equalTo(expectedValue)));
    }
}
