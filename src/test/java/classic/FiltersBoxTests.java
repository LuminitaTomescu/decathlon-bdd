package classic;

import commons.DataValues;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FiltersBoxTests extends BaseTest {

    @Test
    // As a user I would like to filter products by gender
    public void findProductsByGenderFilter() {
        driver.get(DataValues.decathlonFoundProductPageUrl);

        String searchKeywordGender = "FEMEI";

        WebElement genderFilterField = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[2]/div/div[2]/a/div/label/span"));
        genderFilterField.click();

        // the only solution found to instruct driver that the page has been partially modified
        driver.navigate().refresh();

        WebElement searchGenderResult = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[1]/div[2]"));
        String searchGenderResultValue = searchGenderResult.getText();

        Assert.assertEquals(searchKeywordGender, searchGenderResultValue);
        System.out.println("The searched gender is: " + searchGenderResultValue);
    }

    @Test
    // As a user I would like to filter accessories by color
    public void findProductsByColorFilter() {
        driver.get(DataValues.decathlonColorProductPageUrl);

        String searchColor = "GALBEN";

        WebElement accessoriesColor = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[2]/div/div[2]/a"));
        accessoriesColor.click();

        // the only solution found to instruct driver that the page has been partially modified
        driver.navigate().refresh();

        WebElement accessoriesColorFound = driver.findElement(By.xpath("//*[@id=\"list-page-container\"]/ul/li[1]/div[2]/div/div"));
        String accessoriesColorFoundValue = accessoriesColorFound.getText();

        Assert.assertEquals(searchColor, accessoriesColorFoundValue);
        System.out.println("The searched color is: " + accessoriesColorFoundValue);
    }
}
