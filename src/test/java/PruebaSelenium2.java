import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class PruebaSelenium2 {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validaTituloWikipediaSelenium() {
        String tituloEsperado = "Selenium";
        String tituloImagenEsperado = "Selenium.";

        driver.get("https://es.wikipedia.org/wiki/Selenium");

        By tituloBy = By.className("mw-page-title-main");
        WebElement titulo = driver.findElement(tituloBy);
        String valorTitulo = titulo.getText();
        Assert.assertEquals(valorTitulo, tituloEsperado, "El título debería ser correcto.");

        By tituloImagenBy = By.className("cabecera");
        WebElement tituloImagen = driver.findElement(tituloImagenBy);
        String valorTituloImagen = tituloImagen.getText();
        Assert.assertEquals(valorTituloImagen, tituloImagenEsperado, "El título de la imagen debería ser correcto.");

    }
}