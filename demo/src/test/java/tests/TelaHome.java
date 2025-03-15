package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TelaHome 
{
    private WebDriver driver;

    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

	@Test
	@DisplayName("01 - Validar acesso a tela Home.")
	void validaAcesso_TelaHome() 
    {
		driver.get("https://starbugs.vercel.app/");

        // Adicionada importação de ExpectedConditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        
        assertEquals("Bora tomar um café? Nós levamos até você!", title.getText(), "Verificando o Slogan da tela home.");
    }

    @AfterEach
    public void tearDown() 
    {
        if (driver != null) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains("vercel.app"));
                    // Espera até que a URL correta seja carregada
            driver.quit();
        }
    }
}