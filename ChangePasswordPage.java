package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class ChangePasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void closeAdIfPresent() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src*='ads']")));
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='close']")));
            closeBtn.click();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            driver.switchTo().defaultContent(); // always reset
        }
    }

    public void navigateToChangePassword() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action='customer-menu-toggle']")));
        dropdown.click();

        WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account")));
        myAccount.click();

        WebElement changePasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Change Password")));
        changePasswordLink.click();
    }

    public void enterCurrentPassword(String currentPassword) {
        WebElement currentPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));
        currentPwd.sendKeys(currentPassword);
    }

    public void enterNewPassword(String newPassword) {
        WebElement newPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        newPwd.sendKeys(newPassword);
    }

    public void enterConfirmPassword(String newPassword) {
        WebElement confirmPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation")));
        confirmPwd.sendKeys(newPassword);
    }

    public void clickSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Save']")));
        saveBtn.click();
    }

    public boolean isPasswordChangedSuccessfully() {
        try {
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
            return successMsg.getText().contains("You saved the account information.");
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void changePassword(String currentPwd, String newPwd) {
        closeAdIfPresent();
        navigateToChangePassword();
        closeAdIfPresent(); // in case another ad appears

        enterCurrentPassword(currentPwd);
        enterNewPassword(newPwd);
        enterConfirmPassword(newPwd);
        clickSaveButton();
    }
}
