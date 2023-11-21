package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();
        //verify the text 'Products'
        String expectedText = "Products";
        WebElement actualText = driver.findElement(By.xpath("//span[@class='title']"));
        String text = actualText.getText();
        Assert.assertEquals(expectedText,text);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("“secret_sauce”");
        //click on login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //verify that six products are displayed on page
        List<WebElement>noOfProductsDisplayed = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int number = noOfProductsDisplayed.size();
        System.out.println("Number of Products displayed: " +number);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
