package TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.SignupPage;

public class SignUpTest {

    WebDriver driver;
    SignupPage signup;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.manage().window().maximize();

        signup = new SignupPage(driver);

    }
    @Test
    public void testSignup() {

        signup.enterFirstName("Mounika");
        signup.enterLastName("Reddy");
        signup.enterEmail("monireddy5@gmail.com");
        signup.enterPassword("Omsairam@1");
        signup.enterConfirmPassword("Omsairam@1");
        signup.clickCreateAccount();
    }

    ///@AfterMethod
   // public void tearDown() {
   //         driver.quit();


}
