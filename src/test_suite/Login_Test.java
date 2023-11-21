package test_suite;

import browser_factory.Base_Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * <p>
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * <p>
 * <p>
 * 2. verifyTheErrorMessage
 * <p>
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class Login_Test extends Base_Test {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a")).click();

        // Verify the text ‘Welcome Back!
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);

        System.out.println("Method 1");
    }

    @Test
    public void verifyTheErrorMessage() {

        //click on sign in
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a")).click();

        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime12@gmail.com");

        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("pri123");

        //Click on Login button
        driver.findElement(By.className("button-primary")).click();

        // Verify the error message ‘Invalid emailor password.
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();

        Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("Method 2");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
