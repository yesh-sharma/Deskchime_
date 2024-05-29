package loginpagetesting;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class Testingofloginpage {

	@FindBy(css = "input[placeholder='Email address']")
	WebElement useremail;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordEle;

	@FindBy(css = "button[type='submit']")
	WebElement submit;

	@Test(dataProvider = "getData")
	public void validcredendetials(HashMap<String, String> input) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Login log = new Login(driver);
	
		log.Goto();

		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();
		log.loginApplication(input.get("email"), input.get("password"));
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "yeshsharma516032@gmail.com");
		map.put("password", "Yesh1234");
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "yesh@zasyasolutions.com");
		map1.put("password", "Yesh255198@");
		return new Object[][] { { map }, { map1 } };

	}

	public void invalidcredentials1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://deskchime.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolution.com");
		passwordEle.sendKeys("Yesh255198@");
		submit.click();

		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);
			

		}
		driver.close();
	}

	public void invalidcredentials2() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");

		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolutions.com");
		passwordEle.sendKeys("Yesh2551981@");
		submit.click();

		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);
		

		}
		driver.close();
	}

	public void emptyusernamefield() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();
		PageFactory.initElements(driver, this);
		useremail.sendKeys("yeshsharma516032@gmail.com");

		submit.click();
		System.out.println("popup message"
				+ driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		driver.close();

	}

	public void emptypasswordfield() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();
		PageFactory.initElements(driver, this);

		passwordEle.sendKeys("Yesh2551981@");
		submit.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		driver.close();
	}

	public void passwordresetlink() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();
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
		driver.close();
	}
@Test
	public void userlogout() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");

		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();

		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolutions.com");
		passwordEle.sendKeys("Yesh255198@");
		submit.click();
            Login login =new Login(driver);
            login.avoidFeedbackpopup();

	
		driver.findElement(By.xpath(
				"//button[@class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default text-slate-600 hover:text-teal-500 active:text-teal-600 disabled:text-zinc-400 h-12 p-3 text-base relative']//div[1]"))
				.click();

		driver.close();
	}

}
