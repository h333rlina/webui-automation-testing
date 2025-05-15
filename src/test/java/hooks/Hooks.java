package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        // Setup ChromeDriver otomatis sesuai versi Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000); // delay 5 detik agar browser tidak langsung tertutup
            driver.quit();
        }
    }
}
