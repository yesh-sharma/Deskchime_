package basetest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import utility.ConfigReader;

public class BaseTest {



	public WebDriver driver;
    ConfigReader config = new ConfigReader(); // Instance of ConfigReader



    @BeforeMethod
    public void setUp() {
        // Get the browser value from the properties file


    	String browser = System.getProperty("browser") !=null ? System.getProperty("browser") : config.getProperty("browser");
       // String browser = config.getProperty("browser");

        // Initialize the driver based on the browser value
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();

        }
        else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported.");
        }

        driver.manage().deleteAllCookies();
       driver.manage().window().maximize();

    }




	public void loginApplication() throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email address']")));

		email.sendKeys("yesh@zasyasolutions.com");

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));

		password.sendKeys("Yesh255198@");
		WebElement submitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));

		submitbutton.click();




}



	public void Goto() {
		driver.manage().deleteAllCookies();
		driver.get("https://deskchime.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement loginbutton= wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/auth/login']")));
		loginbutton.click();
	}



	public void avoidFeedbackpopup() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


			WebElement FeedbackPopup1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ant-modal-close']")));
			if( FeedbackPopup1.isDisplayed())
			{	Actions actions = new Actions(driver);

			// Move the mouse to the specific coordinates and perform click
			actions.moveByOffset(0, 50).click().perform();
			}
			else {
				System.out.println("No feedback popup shown");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}







}




	 public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destinationPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	        File destination = new File(destinationPath);
	        FileUtils.copyFile(source, destination);
	        return destinationPath;


}
}



