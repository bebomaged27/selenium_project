package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage {
    private WebDriver driver;

    public AppointmentConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAppointmentConfirmationDisplayed() {
        // Check if appointment confirmation message is displayed
        return driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]")).isDisplayed();
    }
}
