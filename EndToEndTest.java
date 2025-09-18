package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

public class EndToEndTest {
    WebDriver driver;
    LoginPage loginPage;
    MyInfoPage myInfoPage;
    ChangePasswordPage changePasswordPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        myInfoPage = new MyInfoPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.login("Admin", "admin123");
       // Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "Dashboard not found after login!");
    }

    @Test(priority = 2)
    public void testFillContactDetails() {
        myInfoPage.goToContactDetails();
        myInfoPage.fillContactDetails("Street 123", "Bhubaneswar", "Odisha", "760001", "9876543210");
    }

    @Test(priority = 3, enabled = false)  
    public void testChangePassword() {
        changePasswordPage.openChangePassword();
        changePasswordPage.changePassword("admin123", "NewPass@123");
    }

    @Test(priority = 4)
    public void testSignOut() {
        myInfoPage.signOut();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
