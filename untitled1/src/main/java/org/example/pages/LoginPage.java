package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        // Navigate to the login page
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.linkText("Make Appointment")).click();
    }

    public void login(String username, String password) {
        // Enter username and password
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);

        // Click on the login button
        driver.findElement(By.id("btn-login")).click();
    }

    public String getErrorMessage() {
        // Get error message
        return driver.findElement(By.cssSelector("p.lead.text-danger")).getText();
    }
}
