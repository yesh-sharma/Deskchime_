package loginpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.BaseTest;


public class Testingofloginpage extends BaseTest {

	public Testingofloginpage() {
		super(); // This will initialize the WebDriver in the BaseTest class
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

		Goto();
		loginApplication();





	}

	public void invalidcredentials1() throws InterruptedException {
		Goto();
		loginApplication();


		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);

		}

	}

	public void invalidcredentials2() throws InterruptedException {

		Goto();
		loginApplication();



		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);

		}

	}

	public void emptyusernamefield() throws InterruptedException {
		Goto();
		loginApplication();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email address']")));

		email.sendKeys("yesh@zasyasolutions.com");
		WebElement submitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));

		submitbutton.click();



		System.out.println("popup message"
				+ driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());

	}

	public void emptypasswordfield() throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email address']")));

		email.sendKeys("yesh@zasyasolutions.com");
		WebElement submitbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));

		submitbutton.click();


		System.out.println(driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());

	}

	public void passwordresetlink() throws InterruptedException {
		Goto();
		loginApplication();


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
		Goto();
		loginApplication();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='logout-btn']")));
		element.click();

	}
}