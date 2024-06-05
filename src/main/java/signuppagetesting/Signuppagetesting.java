package signuppagetesting;

import java.time.Duration;
import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;

@Test
public class Signuppagetesting {

	public void successfulregistration() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("cuzofa@citmo.net");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharma");
		driver.findElement(By.id("register-form_company_name")).sendKeys("llo");
		driver.findElement(By.id("register-form_company_slug")).sendKeys("lol");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c3329@");
		driver.findElement(By.id("register-form_confirm_password")).sendKeys("Hp31c3329@");
		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.close();

	}

	public void emptyfields() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("cuzofa@citmo.net");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharma");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c3329@");
		driver.findElement(By.id("register-form_confirm_password")).sendKeys("Hp31c3329@");
		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		System.out.println(
				driver.findElement(By.xpath("//div[contains(text(),'Please enter your company name!')]")).getText());
		System.out.println(driver
				.findElement(By.xpath("//div[contains(text(),'Please enter your company subdomain!')]")).getText());
		driver.close();
	}

	public void invalidemailformat() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("cuzofa@citmo.net");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharma");
		driver.findElement(By.id("register-form_company_name")).sendKeys("llo");
		driver.findElement(By.id("register-form_company_slug")).sendKeys("lol");
		Thread.sleep(2000);
		WebElement w1 = driver.findElement(By.xpath("//input[@id='register-form_email']"));
		w1.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		// Simulate pressing Backspace to clear the selected text
		w1.sendKeys(Keys.BACK_SPACE);

		w1.sendKeys("yeshsharma516032gmail.com");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c3329@");

		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		driver.close();

	}

	public void existingemailaddress() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("yesh@zasyasolutions.com");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharmfca");
		driver.findElement(By.id("register-form_company_name")).sendKeys("lfgbdflo");
		driver.findElement(By.id("register-form_company_slug")).sendKeys("lgbfgbol");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c3329@");
		driver.findElement(By.id("register-form_confirm_password")).sendKeys("Hp31c3329@");
		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		WebElement W2 = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"));
		if (W2.isDisplayed()) {
			String text = W2.getText();
			System.out.println("popup message " + text);

		}
		driver.close();
	}

	public void passwordstrength() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("yesh@zsayasolutions.com");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharma");
		driver.findElement(By.id("register-form_company_name")).sendKeys("llo");
		driver.findElement(By.id("register-form_company_slug")).sendKeys("lol");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c332");
		driver.findElement(By.id("register-form_confirm_password")).sendKeys("Hp31c332");
		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		WebElement W2 = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
		if (W2.isDisplayed()) {
			String text = W2.getText();
			System.out.println("popup message " + text);

		}
		driver.close();
	}

	public void passwordconfirmation() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.get("https://deskchime.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("yesh@zsayasolutions.com");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/form/button/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("register-form_first_name")).sendKeys("sharma");
		driver.findElement(By.id("register-form_company_name")).sendKeys("llo");
		driver.findElement(By.id("register-form_company_slug")).sendKeys("lol");
		driver.findElement(By.id("register-form_password")).sendKeys("Hp31c3329@");
		driver.findElement(By.id("register-form_confirm_password")).sendKeys("Hp31c332");
		WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		WebElement W2 = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
		if (W2.isDisplayed()) {
			String text = W2.getText();
			System.out.println("popup message " + text);

		}
		driver.close();
	}

}