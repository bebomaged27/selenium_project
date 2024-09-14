import org.example.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void testUnauthorizedLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login("invalid_username123", "invalid_password456");

        WebElement errorMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed. Login should have failed.");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testLoadLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        WebElement title = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(title.isDisplayed());
    }

    @Test(priority = 2)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        testLoadLoginPage();
        loginPage.login("John Doe", "ThisIsNotAPassword");

        String homepageTitle = driver.getTitle();
        Assert.assertTrue(homepageTitle.contains("CURA Healthcare Service"), "Login unsuccessful.");
    }

    @Test(priority = 3)
    public void testBookAppointmentWithNoData() throws InterruptedException {
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("", "", "");

        String dateValue = appointmentPage.getDateFieldValue();
        Assert.assertNotNull(dateValue, "Date field is empty or null.");
        Assert.assertTrue(dateValue.isEmpty(), "Date field is not empty.");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void ConfirmAppointment() throws InterruptedException {
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("Hongkong CURA Healthcare Center", "This is a test appointment.", "2024-05-10");
        WebElement confirmationMessage =driver.findElement(By.tagName("h2"));
        Assert.assertTrue(confirmationMessage.isDisplayed());

    }

    @Test(priority = 5)
    public void testBookAppointmentWithData() throws InterruptedException {
        LoginPage homePage = new LoginPage(driver);
        homePage.navigateToLoginPage();
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("Hongkong CURA Healthcare Center", "This is a test appointment.", "2024-05-10");

        WebElement confimation_message=driver.findElement(By.tagName("h2"));
        Assert.assertTrue(confimation_message.isDisplayed());

        //Assert.assertTrue(appointmentPage.isAppointmentConfirmationDisplayed(), "Appointment booking failed.");
    }

    @Test(priority = 6)
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        homePage.logout();

        LoginPage loginPage = new LoginPage(driver);

        driver.findElement(By.id("menu-toggle")).click();
        WebElement LoginBtn=driver.findElement(By.linkText("Login"));
        Assert.assertTrue(LoginBtn.isDisplayed());


    }

    @Test(priority = 7)
    public void testResponsiveDesign() {
        ResponsiveDesignPage responsiveDesignPage = new ResponsiveDesignPage(driver);
        Assert.assertTrue(responsiveDesignPage.isDesktopViewDetected(), "Desktop view not detected.");
        Assert.assertTrue(responsiveDesignPage.isTabletLandscapeViewDetected(), "Tablet (landscape) view not detected.");
        Assert.assertTrue(responsiveDesignPage.isTabletPortraitViewDetected(), "Tablet (portrait) view not detected.");
        Assert.assertTrue(responsiveDesignPage.isMobileViewDetected(), "Mobile view not detected.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
