import org.example.pages.AppointmentPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookAppointmentWithNoDataTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBookAppointmentWithNoData() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("", "", "");

        String dateValue = appointmentPage.getDateFieldValue();
        Assert.assertNotNull(dateValue, "Date field is empty or null.");
        Assert.assertTrue(dateValue.isEmpty(), "Date field is not empty.");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
