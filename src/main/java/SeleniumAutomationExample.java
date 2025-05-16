//package com.example.automation;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.TimeoutException;
//import java.time.Duration;
//
//public class SeleniumAutomationExample {
//
//    public static void main(String[] args) {
//        // Use environment variable or configuration for URL
//        String url = System.getenv("TARGET_URL");
//        if (url == null || url.isEmpty()) {
//            System.err.println("Environment variable TARGET_URL is not set.");
//            return;
//        }
//
//        WebDriver driver = null;
//
//        try {
//            // Setup ChromeDriver path (can also be done via system property or WebDriverManager)
//            System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//
//            driver = new ChromeDriver();
//            driver.get(url);
//
//            // Use WebDriverWait instead of Thread.sleep
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-box")));
//            searchBox.sendKeys("Selenium");
//
//            // Example: check for a non-existing element with wait and catch block
//            try {
//                WebElement nonExistingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("non-existent-element")));
//                nonExistingElement.click();
//            } catch (TimeoutException e) {
//                System.out.println("Non-existent element not found within timeout.");
//            }
//
//        } catch (NoSuchElementException e) {
//            System.err.println("Element not found. Check the locator.");
//        } catch (TimeoutException e) {
//            System.err.println("Timeout occurred while waiting for an element.");
//        } catch (Exception e) {
//            System.err.println("Unexpected error: " + e.getMessage());
//        } finally {
//            if (driver != null) {
//                driver.quit(); // Ensures driver closes even if an exception is thrown
//            }
//        }
//    }
//}
