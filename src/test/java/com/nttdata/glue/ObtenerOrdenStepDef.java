package com.nttdata.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ObtenerOrdenStepDef {

    private String url;
    private Response response;

    @Given("la URL del servicio es {string}")
    public void laUrlDelServicioEs(String url) {
        this.url = url;
    }

    @When("envío una solicitud GET")
    public void envioUnaSolicitudGET() {
        response = RestAssured.given()
                .when()
                .get(url);
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("la respuesta debería ser")
    public void laRespuestaDeberiaSer(String expectedResponse) {
        try {
            // Convertir la respuesta esperada y la respuesta real a objetos JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode expectedJson = objectMapper.readTree(expectedResponse);
            JsonPath actualJson = new JsonPath(response.getBody().asString());

            // Comparar cada campo del JSON
            assertEquals(expectedJson.get("id").asInt(), actualJson.getInt("id"));
            assertEquals(expectedJson.get("petId").asInt(), actualJson.getInt("petId"));
            assertEquals(expectedJson.get("quantity").asInt(), actualJson.getInt("quantity"));
            assertEquals(expectedJson.get("status").asText(), actualJson.getString("status"));
            assertEquals(expectedJson.get("complete").asBoolean(), actualJson.getBoolean("complete"));

            // Normalizar la fecha para comparación
            String expectedDate = expectedJson.get("shipDate").asText();
            String actualDate = actualJson.getString("shipDate");

            // Comparar fechas ignorando el formato
            assertEquals(normalizeDate(expectedDate), normalizeDate(actualDate));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al comparar la respuesta JSON", e);
        }
    }

    private String normalizeDate(String date) {
        // Reemplazar el sufijo +0000 por Z para normalizar el formato de fecha
        return date.replace("+0000", "Z");
    }
}
