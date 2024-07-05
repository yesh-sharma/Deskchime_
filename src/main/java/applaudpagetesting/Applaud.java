package applaudpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;
import loginpagetesting.Login;
import retryanalyzer.RetryAnalyzer;

@Test
public class Applaud {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void sendApplaud() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));

		element.click();

		// click on create
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//button[@class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative']")));
		element2.click();

		// enter member name
		driver.findElement(By.id("user_id")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/div")).click();
		// enter category
		driver.findElement(By
				.xpath("/html/body/div[1]/div/div/main/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div/div/div"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[5]/div/span")).click();
		driver.findElement(By.id("comment")).sendKeys("xyz");
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
		element3.click();
		driver.close();

	}

	public void useMonthFilter() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		element.click();
		WebElement element2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select month']")));
		element2.click();
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Apr']")));
		element3.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Apr 22, 2024']")).getText());

		driver.close();

	}

	public void seeReceivedApplauds() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		element.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element2.click();
		driver.close();
	}

	public void seeSentApplauds() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		element.click();

		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sent']")));

		element2.click();

		driver.close();

	}
}