package applaudpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import loginpagetesting.Login;

@Test
public class Applaud {

	public void sendApplaud() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[normalize-space()='Applaud']")).click();

		// click on create

		driver.findElement(By.xpath("/html/body/div/div/div/main/div/div[1]/div[2]/button[2]")).click();

		// enter member name
		driver.findElement(By.id("user_id")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/div")).click();
		// enter category
		driver.findElement(By
				.xpath("/html/body/div[1]/div/div/main/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div/div/div"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[5]/div/span")).click();
		driver.findElement(By.id("comment")).sendKeys("xyz");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.close();

	}

	public void useMonthFilter() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[normalize-space()='Applaud']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select month']")).click();
		driver.findElement(By.xpath("//div[text()='Apr']")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Apr 22, 2024']")).getText());
	}

	public void seeReceivedApplauds() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[normalize-space()='Applaud']")).click();
		driver.findElement(By.xpath("//span[text()='Received']")).click();
		driver.close();
	}

	public void seeSentApplauds() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[normalize-space()='Applaud']")).click();
		driver.findElement(By.xpath("//span[text()='Sent']")).click();
		driver.close();

	}
}