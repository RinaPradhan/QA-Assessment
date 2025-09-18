package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {
    private By myInfoMenu = By.xpath("//span[text()='My Info']");
    private By contactDetailsTab = By.xpath("//a[text()='Contact Details']");
    private By street1 = By.xpath("//label[text()='Street 1']/../following-sibling::div/input");
    private By city = By.xpath("//label[text()='City']/../following-sibling::div/input");
    private By state = By.xpath("//label[text()='State/Province']/../following-sibling::div/input");
    private By zip = By.xpath("//label[text()='Zip/Postal Code']/../following-sibling::div/input");
    private By mobile = By.xpath("//label[text()='Mobile']/../following-sibling::div/input");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By profileDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By logoutBtn = By.xpath("//a[text()='Logout']");

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public void goToContactDetails() {
        click(myInfoMenu);
        click(contactDetailsTab);
    }

    public void fillContactDetails(String street1Text, String cityText, String stateText, String zipText, String mobileText) {
        type(street1, street1Text);
        type(city, cityText);
        type(state, stateText);
        type(zip, zipText);
        type(mobile, mobileText);
        click(saveBtn);
    }

    public void signOut() {
        click(profileDropdown);
        click(logoutBtn);
    }
}
