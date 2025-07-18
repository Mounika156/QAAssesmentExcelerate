package TestCases;

import Pages.LoginPage;
import Pages.SignOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignOutTest {

    WebDriver driver;
    LoginPage login;

    SignOutPage signOutPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        signOutPage = new SignOutPage(driver);
        login = new LoginPage(driver);
    }

    @Test
    public void testLoginAndLogout() {
        login.enterEmail("mounikared6@gmail.com");
        login.enterPassword("Omsairam@1");
        login.clickSignIn();
        signOutPage.clickProfileDropdown();
        signOutPage.clickSignOut();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


