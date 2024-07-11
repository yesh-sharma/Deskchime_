package followupspagetesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;
import loginpagetesting.Login;
import retryanalyzer.RetryAnalyzer;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class Followup1on1 {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set the desired capabilities for the browser you want to use
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        // URL of the remote Selenium server or Selenium Grid hub
        URL remoteUrl = new URL("http://192.168.29.48:4444");

        // Initialize the RemoteWebDriver with the remote URL and desired capabilities
        driver.set(new RemoteWebDriver(remoteUrl, capabilities));
        
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

    private WebDriver getDriver() {
        return driver.get();
    }
    
    
@Test
	public void create1on1() throws InterruptedException {
		 WebDriver driver = getDriver();
	        Login login = new Login(driver);
	
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1-on-1s")));

		element.click();
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='create-follow-up-button']")));

		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'yash')]")));

		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select date']")));

		element3.click();

		WebElement element4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-picker-today-btn")));
		element4.click();

		WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='ant-select select-tag shrink-0 ant-select-single ant-select-show-arrow ant-select-show-search']//div[@class='ant-select-selector']")));
		element5.click();

		LocalTime currentTime = LocalTime.now();
		// Extract hour and minute components
		int hour = currentTime.getHour();
		int minute = currentTime.getMinute();
		System.out.println(hour);
		System.out.println(minute);
		// Print the hour and minute

		if (hour == 10 && minute >= 1 && minute <= 29) {

			driver.findElement(By.xpath("//div[text()='11:00 PM']")).click();

		} else if (hour == 10 && minute >= 30 && minute <= 59) {
			driver.findElement(By.xpath("//div[text()='11:30 PM']")).click();

		} else if (hour == 11 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='12:00 PM']")).click();

		} else if (hour == 11 && minute >= 30 && minute < 59) {

			driver.findElement(By.xpath("//div[text()='12:30 PM']")).click();

		} else if (hour == 12 && minute >= 1 && minute < 29) {

			driver.findElement(By.xpath("//div[text()='01:00 PM']")).click();
		} else if (hour == 12 && minute >= 30 && minute < 59) {
			driver.findElement(By.xpath("//div[text()='01:30 PM']")).click();
		} else if (hour == 13 && minute >= 1 && minute < 29) {

			driver.findElement(By.xpath("//div[text()='02:00 PM']")).click();

		} else if (hour == 13 && minute >= 30 && minute < 59) {

			driver.findElement(By.xpath("//div[text()='02:50 PM']")).click();
		} else if (hour == 14 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='03:00 PM']")).click();

		} else if (hour == 14 && minute >= 30 && minute < 59) {
			driver.findElement(By.xpath("//div[text()='03:30 PM']")).click();

		} else if (hour == 15 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='04:00 PM']")).click();
		} else if (hour == 15 && minute >= 30 && minute < 59) {
			driver.findElement(By.xpath("//div[text()='04:30 PM']")).click();

		} else if (hour == 16 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='05:00 PM']")).click();

		} else if (hour == 16 && minute >= 30 && minute < 59) {

			driver.findElement(By.xpath("//div[text()='05:30 PM']")).click();
		} else if (hour == 17 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='06:00 PM']")).click();
		} else if (hour == 17 && minute >= 30 && minute < 59) {
			driver.findElement(By.xpath("//div[text()='06:30 PM']")).click();
		} else if (hour == 18 && minute >= 1 && minute < 29) {
			driver.findElement(By.xpath("//div[text()='07:00 PM']")).click();

		} else if (hour == 18 && minute >= 30 && minute < 59) {
			driver.findElement(By.xpath("//div[text()='07:30 PM']")).click();

		}

		WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='tiptap ProseMirror text-sm min-h-[80px] p-3 max-h-80 overflow-y-auto']")));

		element6.sendKeys("1 on 1 testing");

		WebElement element7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Next')]")));

		element7.click();

		WebElement element8 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save & Continue')]")));

		element8.click();
		System.out.println("1 on 1 meetings created sucessfully");

	

	}

	@Test
	public void userCanDelete1on1Meeting() throws InterruptedException {

		 WebDriver driver = getDriver();
	        Login login = new Login(driver);
	        login.Goto();
	
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1-on-1s")));

		element.click();

		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("svg[width='4']")));

		element1.click();

		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='py-[5px] px-3']")));

		element2.click();
		
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Yes']")));

		element3.click();

	
		

	}
	
@Test
	
	public void create1on1WithoutSpecifyDateandtime() throws InterruptedException {

		 WebDriver driver = getDriver();
	        Login login = new Login(driver);
	        login.Goto();
	

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1-on-1s")));

		element.click();
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='create-follow-up-button']")));

		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'sharma')]")));

		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select date']")));

		element3.click();


		WebElement element4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-picker-today-btn")));
		element4.click();
		
		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Next')]")));

		element5.click();
	
	 
	
}
}
