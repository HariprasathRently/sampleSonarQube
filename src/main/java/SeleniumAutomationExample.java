import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class SeleniumAutomationExample {

    public static void main(String[] args) {
        // Error 1: Unused variable (will trigger a code smell)
        String browser = "Chrome";

        // Error 2: Hardcoded URL (Security issue)
        String url = "http://example.com";  // Should be avoided. Use configuration files or environment variables

        // Error 3: WebDriver not properly initialized (will throw an exception)
        WebDriver driver = new ChromeDriver();  // Assuming ChromeDriver is properly set up, but no setup for path.

        try {
            // Error 4: No explicit wait or improper wait
            driver.get(url);
            WebElement element = driver.findElement(By.id("search-box"));
            element.sendKeys("Selenium");

            // Error 5: NullPointerException if the element is not found or is null
            String value = element.getText();  // This might throw NullPointerException if element is not found


            // Error 6: Unhandled exception (NoSuchElementException) - missing exception handling
            WebElement nonExistingElement = driver.findElement(By.id("non-existent-element"));
            nonExistingElement.click();  // This line will cause a failure, but no exception handling is provided.

            // Error 7: Inefficient use of thread.sleep - Unnecessary wait and poor practice
            Thread.sleep(5000);  // Using Thread.sleep is not recommended in Selenium

            // Error 8: Using driver.quit() inside a method but not closing the driver properly
            // This is not ideal because if an exception occurs before this point, the driver might not close properly.
            driver.quit();

        } catch (NoSuchElementException e) {
            // Error 9: Catching too general of an exception
            System.out.println("Element not found, please check the locator.");
        } catch (TimeoutException e) {
            // Error 10: Catching too general of an exception
            System.out.println("Timeout occurred, element did not appear in time.");
        } catch (Exception e) {
            // Error 11: Catching too general of an exception, may miss more specific exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Error 12: Driver may not be closed properly
            if (driver != null) {
                driver.quit();
            }
        }
    }
}