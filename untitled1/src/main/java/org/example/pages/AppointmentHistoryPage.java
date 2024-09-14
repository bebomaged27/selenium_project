package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentHistoryPage {
    private final WebDriver driver;

    // Locators
    private final By appointmentHistoryButton = By.id("btn-view-appointment");
    private final By appointmentRows = By.cssSelector(".appt-body > tr");

    public AppointmentHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAppointmentHistoryPage() {
        driver.findElement(appointmentHistoryButton).click();
    }

    public int getNumberOfAppointments() {
        List<WebElement> rows = driver.findElements(appointmentRows);
        return rows.size();
    }
}
