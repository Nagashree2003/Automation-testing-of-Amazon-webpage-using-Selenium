package mytest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class program1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize WebDriverWait with explicit wait timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Navigate to Amazon website
        driver.get("https://www.amazon.in/");

        // Wait until the page is fully loaded
        waitForPageLoad();
    }

    private void waitForPageLoad() {
        // Create a wait object for the document readiness
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        // Wait until the condition is true
        wait.until(pageLoadCondition);
    }

    @Test
    public void verifyTitle() {
        // Fetch the actual title
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle); // Debugging: Print the actual title

        // Expected title
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

        // Verify Amazon homepage title
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected value");
    }

    @Test
    public void verifySearchproduct () {
        // Locate the search box element
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // Enter search keyword
        searchBox.sendKeys("laptop");

        // Submit the search by pressing Enter key
        searchBox.submit();

        // Click on the first product in the search results
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.s-main-slot div.s-result-item")));
        firstProduct.click();

        // Verify product detail page contains product name
        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
        Assert.assertTrue(productName.isDisplayed(), "Product name is not displayed");
    }

    @Test
    public void verifySignInPage() {
        // Locate and click the sign-in button/link
        WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
        signInButton.click();

        // Wait for the sign-in page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

        // Locate the mobile/email input field and the continue button
        WebElement mobileOrEmailField = driver.findElement(By.id("ap_email"));
        WebElement continueButton = driver.findElement(By.id("continue"));

        // Verify the elements are displayed
        Assert.assertTrue(mobileOrEmailField.isDisplayed(), "Mobile or email field is not displayed");
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button is not displayed");
    }

    @Test
    public void verifyCartIsEmpty() {
        // Locate and click the cart button/link
        WebElement cartButton = driver.findElement(By.id("nav-cart"));
        cartButton.click();

        // Wait for the cart page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-active-cart")));

        // Locate the empty cart message element
        WebElement emptyCartMessage = driver.findElement(By.xpath("//h2[contains(text(),'Your Amazon Cart is empty')]"));

        // Verify the empty cart message is displayed
        Assert.assertTrue(emptyCartMessage.isDisplayed(), "The cart is not empty or the empty cart message is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}