package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class Demoqa {

    WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        //String browser = System.getProperty("browser");

         /*if (browser.equals("chrome")) {
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://demoqa.com/automation-practice-form");
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

          */
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void HomeQaTest() throws InterruptedException {

        //Student Registration Form

        WebElement firstName = driver.findElement(By.cssSelector("form [placeholder='First Name']"));
        firstName.sendKeys("Pablo");
        WebElement lastName = driver.findElement(By.cssSelector("form [placeholder='Last Name']"));
        lastName.sendKeys("Kor");
        WebElement email = driver.findElement(By.cssSelector("[id='userEmail']"));
        email.sendKeys("moroz-p@mail.ru");
        WebElement gender = driver.findElement(By.xpath("//div [contains(@class,'col-md-9 col-sm-12')]// div [@class='custom-control custom-radio custom-control-inline']//label[text()='Male']"));
        gender.click();
        //Assertions.assertEquals("true", gender.getAttribute("Male")); тут не понятно как именн ознать какой атрибут меняется и т.д
        WebElement number = driver.findElement(By.cssSelector("[id=userNumber]"));
        number.sendKeys("9534042323");

        WebElement month = driver.findElement(By.cssSelector("div [class='react-datepicker__input-container'] #dateOfBirthInput"));
        month.click();

        WebElement chooseMonth = driver.findElement(By.cssSelector("[class='react-datepicker__month-select'] option:nth-child(11)"));
        chooseMonth.click();
        WebElement year = driver.findElement(By.xpath("//*[contains(@class,'react-datepicker__year-select')]"));
        year.click();
        WebElement chooseYear = driver.findElement(By.xpath("//*[contains(@class,'react-datepicker__year-select')]"));
        chooseYear.click();
        Thread.sleep(5000);
        WebElement firstHobbies = driver.findElement(By.xpath("//div [contains(@class,'col-md-9 col-sm-12')]//div [contains(@class,'custom-control custom-checkbox custom-control-inline')]//label[text()='Sports']"));
        firstHobbies.click();
        WebElement secondHobbies = driver.findElement(By.xpath("//div [contains(@class,'col-md-9 col-sm-12')]//div [contains(@class,'custom-control custom-checkbox custom-control-inline')]//label[text()='Reading']"));
        secondHobbies.click();
        WebElement thirdHobbies = driver.findElement(By.xpath("//div [contains(@class,'col-md-9 col-sm-12')]//div [contains(@class,'custom-control custom-checkbox custom-control-inline')]//label[text()='Music']"));
        thirdHobbies.click();
        WebElement address = driver.findElement(By.cssSelector("[id='currentAddress']"));
        address.sendKeys("Novosibirsk");
        WebElement state = driver.findElement(By.cssSelector("[id='state']"));
        state.click();
        WebElement chooseState = driver.findElement(By.cssSelector("[id='state'] [class='css-1uccc91-singleValue']"));
        chooseState.click();
        WebElement city = driver.findElement(By.cssSelector("[id='city']"));
        city.click();
        WebElement chooseCity = driver.findElement(By.cssSelector("[id='city'] [class='css-1uccc91-singleValue']"));
        chooseCity.click();
        driver.findElement(By.cssSelector("[id='submit']"));
        chooseState.click();
        List<WebElement> newList=driver.findElements(By.cssSelector("[class='modal-body']"));
        Assertions.assertFalse(newList.isEmpty());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
