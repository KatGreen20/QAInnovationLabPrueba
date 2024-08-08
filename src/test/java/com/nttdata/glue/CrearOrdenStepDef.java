package com.nttdata.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;


public class CrearOrdenStepDef {
    /*
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
        response = SerenityRest.given()
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
    public void laRespuestaDeberiaSer(String expectedResponse) throws Exception {
        // Verificar que la respuesta no sea nula
        if (response == null) {
            throw new RuntimeException("La respuesta de la API es nula");
        }

        String actualResponse = response.getBody().asString();

        // Crear el ObjectMapper de Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Parsear las cadenas JSON en objetos JsonNode
        JsonNode expectedJson = mapper.readTree(expectedResponse);
        JsonPath actualJson = new JsonPath(actualResponse);

        // Comparar los campos individuales
        assertEquals(expectedJson.get("id").asInt(), actualJson.getInt("id"));
        assertEquals(expectedJson.get("petId").asInt(), actualJson.getInt("petId"));
        assertEquals(expectedJson.get("quantity").asInt(), actualJson.getInt("quantity"));
        assertEquals(expectedJson.get("shipDate").asText(), actualJson.getString("shipDate"));
        assertEquals(expectedJson.get("status").asText(), actualJson.getString("status"));
        assertEquals(expectedJson.get("complete").asBoolean(), actualJson.getBoolean("complete"));
    }*/
}
