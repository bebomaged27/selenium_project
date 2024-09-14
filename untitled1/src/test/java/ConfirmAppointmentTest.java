import org.example.pages.AppointmentPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConfirmAppointmentTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ConfirmAppointment() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("Hongkong CURA Healthcare Center", "This is a test appointment.", "2024-05-10");
        WebElement confirmationMessage =driver.findElement(By.tagName("h2"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
