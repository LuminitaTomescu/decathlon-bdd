package bdd;

import commons.DataValues;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiltersDefinitions {
    public ChromeDriver driver;

    public String searchKeywordGender = "FEMEI";
    public String searchColor = "GALBEN";

    @Given("the user is on the found page product")
    public void theUserIsOnTheFoundPageProduct() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataValues.decathlonFoundProductPageUrl);

    }

    @Given("the user is on the accessories page product")
    public void theUserIsOnTheAccessoriesPageProduct() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataValues.decathlonColorProductPageUrl);
    }

    @When("the user clicks on gender filter")
    public void theUserClicksOnGenderFilter() {
        WebElement genderFilterField = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[2]/div/div[2]/a/div/label/span"));
        genderFilterField.click();
    }

    @When("the user clicks on the favorite color filter")
    public void theUserClicksOnTheFavoriteColorFilter() {
        WebElement accessoriesColor = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[2]/div/div[2]/a"));
        accessoriesColor.click();
    }

    @Then("the user will receive filtered products")
    public void theUserWillReceiveFilteredProducts() {
        WebElement searchGenderResult = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[1]/div[2]/div/div"));
        String searchGenderResultValue = searchGenderResult.getText();

        Assert.assertEquals(searchKeywordGender, searchGenderResultValue);
        System.out.println("The searched gender is: " + searchGenderResultValue);

        driver.quit();
    }

    @Then("the user will receive filtered color products")
    public void theUserWillReceiveFilteredColorProducts() {
        WebElement accessoriesColorFound = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[1]/div[2]/div/div"));
        String accessoriesColorFoundValue = accessoriesColorFound.getText();

        Assert.assertEquals(searchColor, accessoriesColorFoundValue);
        System.out.println("The searched color is: " + accessoriesColorFoundValue);

        driver.quit();
    }
}