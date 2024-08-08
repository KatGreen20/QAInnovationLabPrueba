package com.nttdata.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CrearOrdenStepDef {

    private String url;
    private String requestBody;
    private Response response;

    @Given("la URL del servicio es {string}")
    public void laUrlDelServicioEs(String url) {
        this.url = url;
    }

    @Given("el cuerpo de la solicitud es")
    public void elCuerpoDeLaSolicitudEs(String requestBody) {
        this.requestBody = requestBody;
    }

    @When("envío una solicitud POST")
    public void envioUnaSolicitudPOST() {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(url);
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("la respuesta debería ser")
    public void laRespuestaDeberiaSer(String expectedResponse) {
        assertEquals(expectedResponse, response.getBody().asString());
    }
}
