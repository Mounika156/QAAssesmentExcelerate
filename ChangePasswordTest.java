package TestCases;

import Pages.ChangePasswordPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePasswordTest {
    WebDriver driver;
    LoginPage login;
    ChangePasswordPage changePasswordPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        login = new LoginPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
    }

    @Test
    public void testChangePassword() {
        login.enterEmail("monireddy5@gmail.com");
        login.enterPassword("Omsairam@1");
        login.clickSignIn();

        changePasswordPage.changePassword("Omsairam@1", "Omsairam@123");
        boolean isChanged = changePasswordPage.isPasswordChangedSuccessfully();

        Assert.assertTrue(isChanged, "Password change failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
