package loginpagetesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import retryanalyzer.RetryAnalyzer;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class Testingofloginpage {

	@FindBy(css = "input[placeholder='Email address']")
	WebElement useremail;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordEle;

	@FindBy(css = "button[type='submit']")
	WebElement submit;

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

//	@Test(dataProvider = "getData")
//	public void validcredendetials(HashMap<String, String> input) throws InterruptedException {
//		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());
//
//		driver.manage().window().maximize();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		Login log = new Login(driver);
//
//		log.Goto();
//		log.avoidFeedbackpopup();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement element = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='login-btn']")));
//		element.click();
//		
//		log.loginApplication(input.get("email"), input.get("password"));
//	}
//
//	@DataProvider
//	public Object[][] getData() {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "yeshsharma516032@gmail.com");
//		map.put("password", "Yesh1234");
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "yesh@zasyasolutions.com");
//		map1.put("password", "Yesh255198@");
//		return new Object[][] { { map }, { map1 } };
//
//	}

	public void validcredendetials() throws InterruptedException {

		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		driver.close();

	}

	public void invalidcredentials1() throws InterruptedException {
		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolution.com");
		passwordEle.sendKeys("Yesh255198@");
		submit.click();

		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);

		}
		
	}

	public void invalidcredentials2() throws InterruptedException {

		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolutions.com");
		passwordEle.sendKeys("Yesh2551981@");
		submit.click();

		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);

		}
		
	}

	public void emptyusernamefield() throws InterruptedException {

		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yeshsharma516032@gmail.com");

		submit.click();
		System.out.println("popup message"
				+ driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		

	}

	public void emptypasswordfield() throws InterruptedException {

		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();

		PageFactory.initElements(driver, this);

		passwordEle.sendKeys("Yesh2551981@");
		submit.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		
	}

	public void passwordresetlink() throws InterruptedException {
		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();

		driver.findElement(By.xpath("//div[text()='Forgot password ?']")).click();
		driver.findElement(By.cssSelector("input[data-testid='forgot-email-input']"))
				.sendKeys("yeshsharma516032@gmail.com");
		driver.findElement(By.cssSelector("button[data-testid='forgot-sent-btn']")).click();
		WebElement dialog = driver.findElement(By.xpath(
				"//div[@class='ant-notification-notice ant-notification-notice-success css-3mqfnx ant-notification-notice-closable']"));
		if (dialog.isDisplayed()) {
			String dialogText = dialog.getText();
			System.out.println("Popup message: " + dialogText);

		}
		
	}

	public void userlogout() throws InterruptedException {
		WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='logout-btn']")));
		element.click();
		
	}
}