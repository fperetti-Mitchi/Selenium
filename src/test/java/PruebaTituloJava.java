import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PruebaTituloJava {

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
public void validaTituloWikipediaJava() {
    String tituloEsperado = "Java (lenguaje de programación)";

    driver.get("https://es.wikipedia.org/wiki/Java_(lenguaje_de_programaci%C3%B3n)");

    By tituloBy = By.className("mw-page-title-main");
    WebElement titulo = driver.findElement(tituloBy);
    String valorTitulo = titulo.getText();

    Assert.assertEquals(valorTitulo, tituloEsperado, "El título debería ser correcto.");
}
}