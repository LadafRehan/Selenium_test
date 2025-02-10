package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Open Swag Labs login page
        driver.get("https://www.saucedemo.com/");

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginWithValidCredentials() {
        // Locate correct username and password fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter valid credentials
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Click the correct login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify successful login by checking for dashboard title
        WebElement dashboardElement = driver.findElement(By.className("title"));
        Assert.assertTrue(dashboardElement.isDisplayed(), "Login failed - Dashboard not visible.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}