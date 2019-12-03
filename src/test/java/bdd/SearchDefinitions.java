package bdd;

import commons.DataValues;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDefinitions {

    public ChromeDriver driver;
    public String searchKeyword1 = "PANTALONI";
    public String searchKeyword2 = "pAnTaLOni";
    public String searchKeyword3 = "654W57E5568658";

    @Given("the user is on the search field")
    public void theUserIsOnTheSearchField() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataValues.decathlonHomePageUrl);

        WebElement searchField1 = driver.findElement(By.id("SearchEngine_SearchEngine"));
        searchField1.click();
    }

    @When("the user types a product name")
    public void theUserTypesAProductName() {
        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword1);
    }

    @When("the user types a product name in lower case")
    public void theUserTypesAProductNameInLowerCase () {
        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword2);
    }

    @When("the user types a 3.000 characters keyword")
    public void theUserTypesA3000CharactersKeyword () {
        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword3);
    }

    @And("the user presses the search button")
    public void theUserPressesTheSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.click();
    }

    @And("the user presses the submit Button from the keyboard")
    public void theUserPressesTheSubmitButtonFromTheKeyboard() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.submit();
    }

    @Then("the user will find relevant results")
    public void theUserWillFindRelevantResults() {
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[1]/div[1]/h1"));
        String searchResultValue = searchResult.getText();

        Assert.assertEquals(searchKeyword1, searchResultValue);

        System.out.println("Produsul cautat este: " + searchKeyword1);
        System.out.println("Produsul gasit este: " + searchResultValue);

        driver.quit();
    }

    @Then("the user will find relevant results in upper case")
    public void theUserWillFindRelevantResultsInUpperCase () {
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[1]/div[1]/h1"));
        String searchResultValue = searchResult.getText();

        Assert.assertTrue(searchKeyword2.equalsIgnoreCase(searchResultValue));

        System.out.println("Produsul cautat este: " + searchKeyword2);
        System.out.println("Produsul gasit este: " + searchResultValue);

        driver.quit();
    }

    @Then("the user will receive an error page")
    public void theUserWillReceiveAnErrorPage () {
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div/h2"));
        String searchResultValue = searchResult.getText();

        System.out.println("Produsul cautat este: " + searchKeyword3);
        System.out.println(searchResultValue);

        driver.quit();
    }
}
