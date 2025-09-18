package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {
    private By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By changePasswordLink = By.xpath("//a[text()='Change Password']");
    private By currentPassword = By.name("currentPassword");
    private By newPassword = By.name("newPassword");
    private By confirmPassword = By.name("confirmPassword");
    private By saveBtn = By.xpath("//button[@type='submit']");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void openChangePassword() {
        click(userDropdown);
        click(changePasswordLink);
    }
    
    public void changePassword(String oldPass, String newPass) {
        type(currentPassword, oldPass);
        type(newPassword, newPass);
        type(confirmPassword, newPass);
        click(saveBtn);
    }
}
