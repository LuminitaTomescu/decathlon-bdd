package classic;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import commons.DataValues;

public class SearchBarTests extends BaseTest {

    @Test
    // As a user I would like to find products by clicking the search Button
    public void findProductsByClickingTheSearchButton() {
        driver.get(DataValues.decathlonHomePageUrl);

        String searchKeyword = "PANTALONI";

        WebElement searchField1 = driver.findElement(By.id("SearchEngine_SearchEngine"));
        searchField1.click();

        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[1]/div[1]/h1"));
        String searchResultValue = searchResult.getText();

        Assert.assertEquals(searchKeyword, searchResultValue);
        System.out.println("Produsul cautat este: " + searchKeyword);
        System.out.println("Produsul gasit este: " + searchResultValue);
    }

    @Test
    // As a user I would like to find products by pressing the submit Button from the keyboard
    public void findProductsByPressingTheSubmitButtonFromTheKeyboard() {
        driver.get(DataValues.decathlonHomePageUrl);

        String searchKeyword = "PANTALONI";

        WebElement searchField1 = driver.findElement(By.id("SearchEngine_SearchEngine"));
        searchField1.click();

        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.submit();

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[1]/div[1]/h1"));
        String searchResultValue = searchResult.getText();

        Assert.assertEquals(searchKeyword, searchResultValue);
        System.out.println("Produsul cautat este: " + searchKeyword);
        System.out.println("Produsul gasit este: " + searchResultValue);
    }

    @Test
    // As a user I would like to find products ignoring search keyword case
    public void findProductsIgnoringSearchKeywordCase() {
        driver.get(DataValues.decathlonHomePageUrl);

        String searchKeyword = "pAnTaLOni";

        WebElement searchField1 = driver.findElement(By.id("SearchEngine_SearchEngine"));
        searchField1.click();

        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[1]/div[1]/h1"));
        String searchResultValue = searchResult.getText();
        Assert.assertTrue(searchKeyword.equalsIgnoreCase(searchResultValue));
        System.out.println("Produsul cautat este: " + searchKeyword);
        System.out.println("Produsul gasit este: " + searchResultValue);
    }

    @Test
    // As a user I would like to receive an error page on invalid search keyword
    public void receiveAnErrorPageOnInvalidSearchKeyword() {
        driver.get(DataValues.decathlonHomePageUrl);

        String searchKeyword = "654W57E5568658";

        WebElement searchField1 = driver.findElement(By.id("SearchEngine_SearchEngine"));
        searchField1.click();

        WebElement searchField2 = driver.findElement(By.id("header-searchbar"));
        searchField2.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"SearchEngine_0_SearchEngine_0_screen\"]/form/div[2]/div[1]/div/span[2]"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div/h2"));
        String searchResultValue = searchResult.getText();
        System.out.println("Produsul cautat este: " + searchKeyword);
        System.out.println(searchResultValue);
    }
}