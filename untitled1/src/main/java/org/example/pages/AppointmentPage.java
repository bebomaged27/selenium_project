package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AppointmentPage {
    private final WebDriver driver;

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAppointmentPage() {
        // Navigate to the appointment page
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("btn-make-appointment")).click();
    }



    public void bookAppointment(String facility, String comment, String date) throws InterruptedException {
        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility")));

        // Enter appointment details
        driver.findElement(By.cssSelector("#combo_facility")).sendKeys(facility);
        driver.findElement(By.id("txt_comment")).sendKeys(comment);
        driver.findElement(By.id("txt_visit_date")).sendKeys(date);
        // Click on the 'Book Appointment' button
        driver.findElement(By.id("btn-book-appointment")).click();
    }

    public String getDateFieldValue() {
        // Get value of date field
        return driver.findElement(By.id("txt_visit_date")).getAttribute("value");
    }
}
