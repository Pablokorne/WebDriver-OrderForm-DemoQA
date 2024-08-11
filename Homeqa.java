package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class Homeqa {

    WebDriver driver=null;

    @BeforeEach
    public void setUpDriver() {
        String browser = System.getProperty("browser");

         if (browser.equals("chrome")) {
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
            driver.get("https://demoqa.com/automation-practice-form");
        }
        driver.manage().window().maximize();
    }

    @Test
    public void HomeQaTest() {

        //Student Registration Form
        WebElement firstName = driver.findElement(By.cssSelector("form [placeholder='First Name']"));
        firstName.sendKeys("Pablo");
        WebElement lastName = driver.findElement(By.cssSelector("form [placeholder='Last Name']"));
        lastName.sendKeys("Kor");
        WebElement email = driver.findElement(By.cssSelector("[id='userEmail']"));
        email.sendKeys("moroz-p@mail.ru");
        WebElement gender = driver.findElement(By.cssSelector("div [class='col-md-9 col-sm-12'] input[value='Male']"));
        gender.click();
        Assertions.assertEquals(true, gender.getAttribute("checked"));
        WebElement number = driver.findElement(By.cssSelector("[id=userNumber]"));
        number.sendKeys("9534042323");
        WebElement month = driver.findElement(By.cssSelector("[id='gender-radio-1']"));
        month.click();
        WebElement chooseMonth = driver.findElement(By.cssSelector("[class='react-datepicker__month-select'] option:nth-child(11)"));
        chooseMonth.click();
        WebElement year = driver.findElement(By.xpath("//*[contains(@class,'react-datepicker__year-select')]"));
        year.click();
        WebElement chooseYear = driver.findElement(By.xpath("//*[contains(@class,'react-datepicker__year-select')]"));
        chooseYear.click();
        WebElement subjects = driver.findElement(By.cssSelector("[id=subjectsContainer]"));
        subjects.sendKeys("empty");
        WebElement firstHobbies = driver.findElement(By.cssSelector("[id='hobbies-checkbox-1']"));
        firstHobbies.click();
        WebElement secondHobbies = driver.findElement(By.cssSelector("[id='hobbies-checkbox-2']"));
        secondHobbies.click();
        WebElement thirdHobbies = driver.findElement(By.cssSelector("[id='hobbies-checkbox-3']"));
        thirdHobbies.click();
        WebElement address = driver.findElement(By.cssSelector("[id='currentAddress']"));
        address.sendKeys("Novosibirsk");
        WebElement state = driver.findElement(By.cssSelector("[id='state']"));
        state.click();
        WebElement chooseState = driver.findElement(By.cssSelector("[id='state'] [class='css-1uccc91-singleValue']"));
        chooseState.click();
        WebElement city = driver.findElement(By.cssSelector("[id='city']"));
        state.click();
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
