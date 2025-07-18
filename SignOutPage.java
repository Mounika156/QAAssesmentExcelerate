package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutPage {
    WebDriver driver;

    public SignOutPage(WebDriver driver) {
        this.driver = driver;
    }


    By profileDropdown = By.cssSelector("button[data-action='customer-menu-toggle']");
    By signOutLink = By.linkText("Sign Out");


    public void clickProfileDropdown() {
        driver.findElement(profileDropdown).click();
    }

    public void clickSignOut() {
        driver.findElement(signOutLink).click();
    }

}
