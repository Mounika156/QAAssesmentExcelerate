package TestCases;


import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage login;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        login = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        login.enterEmail("mounikared6@gmail.com");  // ✅ Replace with actual email
        login.enterPassword("Omsairam@1");                      // ✅ Replace with actual password
        login.clickSignIn();

        // Assertion – you may update this based on post-login element/text
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("customer/account"), "Login failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
