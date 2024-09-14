import org.example.pages.ResponsiveDesignPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponsiveDesignTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
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
