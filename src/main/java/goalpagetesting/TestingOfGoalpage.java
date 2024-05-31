package goalpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import loginpagetesting.Login;


public class TestingOfGoalpage {
	public void goalpage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Goals']"))
				.click();
		driver.findElement(By.cssSelector("a[data-testid='goal-create-btn']")).click();
		driver.findElement(By.xpath("//div[text()='Self-Development']")).click();
		driver.findElement(By.id("goals_goals_headers_0_goal_title")).sendKeys("xyz");
		driver.findElement(By.cssSelector("p[data-placeholder='Type something to clarify your goal intentions ...']"))
				.sendKeys("abc");
		driver.findElement(By.cssSelector("button[data-testid='goal-submit-btn']")).click();

	

	}

	public void usersCanSeeOnTrackGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

	
		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Goals']")).click();
		driver.findElement(By.xpath("//div[@data-testid='tab-button-On Track']")).click();
	
	}


public void usersCanSeeCompletedGoals() throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();

	login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");


	login.avoidFeedbackpopup();
	driver.findElement(By.xpath("//span[text()='Goals']")).click();
	driver.findElement(By.xpath("//div[@data-testid='tab-button-Completed']")).click();


}


public void usersCanSeeDelayedGoals() throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();

	login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");


	login.avoidFeedbackpopup();
	driver.findElement(By.xpath("//span[text()='Goals']")).click();
	driver.findElement(By.xpath("//div[@data-testid='tab-button-Delayed']")).click();

}

public void usersCanSeeAbandonedGoals() throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();

	login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");


	login.avoidFeedbackpopup();
	driver.findElement(By.xpath("//span[text()='Goals']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-testid='tab-button-Abandoned']")).click();
}


public void usersCanSeeArchivedGoals() throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();

	login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");


	login.avoidFeedbackpopup();
	driver.findElement(By.xpath("//span[text()='Goals']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-testid='tab-button-Archived']")).click();
}

@Test
public void usersCanUpdateStatus() throws InterruptedException {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();

	login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");


	login.avoidFeedbackpopup();
	driver.findElement(By.xpath("//span[text()='Goals']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("button[data-testid='goal-menu-btn-0']")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("li[data-testid='update-menu-btn-0']")).click();
	driver.findElement(By.cssSelector("span[title='On Track']")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("div[title='Completed'] div[class='ant-select-item-option-content']")).click();
	driver.findElement(By.cssSelector("p[data-placeholder='Comment about the status']")).sendKeys("OK");
	driver.findElement(By.xpath("//div[normalize-space()='Update']")).click();
}









}

