package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

        // Setup ChromeDriver otomatis sesuai versi Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // headless mode (gunakan "--headless" jika versi lama)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000); // delay 5 detik agar browser tidak langsung tertutup
            driver.quit();
        }
    }
}
