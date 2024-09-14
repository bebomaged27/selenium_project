package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResponsiveDesignPage {
    private WebDriver driver;

    public ResponsiveDesignPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDesktopViewDetected() {
        // Check if desktop view is detected
        return driver.findElement(By.tagName("body")).getSize().getWidth() > 1024;
    }

    public boolean isTabletLandscapeViewDetected() {
        // Test tablet view (landscape)
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
        return driver.findElement(By.tagName("body")).getSize().getWidth() <= 1024;
    }

    public boolean isTabletPortraitViewDetected() {
        // Test tablet view (portrait)
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
        return driver.findElement(By.tagName("body")).getSize().getWidth() <= 768;
    }

    public boolean isMobileViewDetected() {
        // Test mobile view
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 667)); // iPhone 6/7/8 resolution
        return driver.findElement(By.tagName("body")).getSize().getWidth() <= 375;
    }
}
