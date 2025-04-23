package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class rigisterSteps {

    WebDriver driver;



   private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Given("User navigates to the registration page")
    public void userNavigatesToTheRegistrationPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @And("Entered first name, lastname")
    public void enteredFirstAnd(DataTable whendata) {
       waitForElement(By.id("member_firstname")).sendKeys(whendata.cell(0,0));
       waitForElement(By.id("member_lastname")).sendKeys(whendata.cell(0,1));


    }
}
