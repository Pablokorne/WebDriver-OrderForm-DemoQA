package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TextError {
    WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
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
        }
        driver = new ChromeDriver();
        driver.get("https://formdesigner.ru/examples/order.html");
        driver.manage().window().maximize();
    }

    @Test
    public void textErrorTest() {
        WebElement cookies = driver.findElement(By.cssSelector("#c-bns #c-p-bn"));
        cookies.click();
        WebElement form = driver.findElement(By.xpath("//h3[contains(text(),'Пример готовой формы')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form);
        WebElement iframe = driver.findElement(By.cssSelector("div#form_1006>iframe"));
        driver.switchTo().frame(iframe);
        WebElement submit = driver.findElement(By.cssSelector("div [class='shift btn'] [type='submit']"));
        submit.click();
        List<WebElement> error = driver.findElements(By.cssSelector("form [class='errorSummary errorSummary_top'] ul"));
        // какой асерт написать? IDE постоянно ругается...
    }
}
