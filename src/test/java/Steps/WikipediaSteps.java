package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaSteps {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
    }

    @Given("Uzytkownik jest na stronie {string}")
    public void uzytkownik_jest_na_stronie(String adresURL) {
        driver.navigate().to(adresURL);
    }
    @When("^Uzytkownik wpisuje (.+) w pole wyszukiwania$")
    public void uzytkownik_wpisuje_w_pole_wyszukiwania(String fraza){
        driver.findElement(By.name("search")).sendKeys(fraza);
    }
    @When("Uzytkownik klika w przycisk Szukaj")
    public void uzytkownik_klika_w_przycisk_szukaj(){
        driver.findElement(By.tagName("button")).click();
    }
    @Then("^(.+) zostaje poprawnie wyszukana$")
    public void zostaje_poprawnie_wyszukana(String tekst) {
       // Assert.assertTrue(tekst,driver.findElement(By.id("firstHeading")).getText().toLowerCase().contains(tekst));
        Assert.assertTrue(driver.findElement(By.id("firstHeading")).getText().toLowerCase().startsWith(tekst));
    }

    @AfterAll
    public static void tearDown(){
        //driver.close();
    }
}
