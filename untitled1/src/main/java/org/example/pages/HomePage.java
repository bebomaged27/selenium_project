package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        // Navigate to the login page
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("btn-make-appointment")).click();

    }

    public void logout() {
        // Perform logout action
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}
