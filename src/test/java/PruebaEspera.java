import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaEspera {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void actividadWaitVisibility() {
        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

        driver.get(url);
        By startButtonBy = By.cssSelector("#start button");

        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(startButtonBy));
        button.click();

        By hiddenElementBy = By.id("finish");
        WebElement hiddenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(hiddenElementBy));

        Assert.assertTrue(hiddenElement.isDisplayed(), "El texto debería ser visible.");
        Assert.assertEquals(hiddenElement.getText(), "Hello World!", "El texto debería ser correcto.");

    }

}