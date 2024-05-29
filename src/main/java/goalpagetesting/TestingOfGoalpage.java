package goalpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import loginpagetesting.Login;

@Test
public class TestingOfGoalpage {

	public void goalpage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		
		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[3]"))
				.click();
		driver.findElement(By.cssSelector("a[data-testid='goal-create-btn']")).click();
		driver.findElement(By.xpath("//div[text()='Self-Development']")).click();
		driver.findElement(By.id("goals_goals_headers_0_goal_title")).sendKeys("xyz");
		driver.findElement(By.cssSelector("p[data-placeholder='Type something to clarify your goal intentions ...']"))
				.sendKeys("abc");
		driver.findElement(By.cssSelector("button[data-testid='goal-submit-btn']")).click();
		driver.close();
	}

	public void usersCanMarkAGoalAsCompleted() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		
		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/aside[1]/div[1]/div[1]/div[2]/ul[1]/li[3]"))
				.click();
		driver.close();
	}
}