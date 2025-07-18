package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
            this.driver = driver;
    }

    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("password-confirmation");
    By createAccountBtn = By.cssSelector("button[title='Create an Account']");

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailText) {
        driver.findElement(email).sendKeys(emailText);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }



}
