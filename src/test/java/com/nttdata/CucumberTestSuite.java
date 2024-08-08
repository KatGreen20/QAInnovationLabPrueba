package com.nttdata;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        glue = "com.nttdata.glue", // El paquete donde se encuentran tus definiciones de pasos
        tags = "@crearOrden" // Puedes cambiar esto según los tags que quieras ejecutar
)
public class CucumberTestSuite {
}
