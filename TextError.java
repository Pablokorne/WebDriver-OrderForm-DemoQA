package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextError {
    WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        String browser = System.getProperty("browser");

        /*if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://formdesigner.ru/examples/order.html");
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://formdesigner.ru/examples/order.html");
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get("https://formdesigner.ru/examples/order.html");
        }*/
        driver = new ChromeDriver();
        driver.get("https://formdesigner.ru/examples/order.html");
        driver.manage().window().maximize();
    }
    @Test
    public void textErrorTest(){
        WebElement form= driver.findElement(By.cssSelector("[class='mainForm user_formish']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",form);
    }
}
