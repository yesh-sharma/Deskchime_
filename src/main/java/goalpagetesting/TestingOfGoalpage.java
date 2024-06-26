package goalpagetesting;


import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;
import loginpagetesting.Login;
@Test
public class TestingOfGoalpage {

	public void userCanCreateGoalForselfDevelopment() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='goal-create-btn']")));
		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Self-Development']")));
		element2.click();
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("goals_goals_headers_0_goal_title")));
		element3.sendKeys("xyz");

		WebElement element4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".is-empty.is-editor-empty")));
		element4.sendKeys("abc");

		WebElement element5 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='goal-submit-btn']")));
		element5.click();
		driver.close();
	}
	
	public void userCanCreateGoalForTeam() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='goal-create-btn']")));
		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='goal-team']")));
		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("goals_goals_headers_0_goal_title")));
		element3.sendKeys("user can create a goal for team");

		WebElement element4 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='is-empty is-editor-empty']")));
		element4.sendKeys("test case for team");

		Actions action = new Actions(driver);
		for (int i = 0; i < 3; i++) {

			action.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(2000);
		}

		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'yash')]")));
		element5.click();

		WebElement element6 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='goal-submit-btn']")));
		element6.click();

	}
	

	public void usersCanSeeOnTrackGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tab-button-On Track']")));
		element1.click();

		driver.close();
	}

	public void usersCanSeeCompletedGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tab-button-Completed']")));
		element1.click();

		driver.close();

	}

	public void usersCanSeeDelayedGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tab-button-Delayed']")));
		element1.click();

		driver.close();

	}

	public void usersCanSeeAbandonedGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tab-button-Abandoned']")));
		element1.click();

		driver.close();

	}

	public void usersCanSeeArchivedGoals() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tab-button-Archived']")));
		element1.click();

		driver.close();
	}

	public void usersCanUpdateStatus() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='goal-menu-btn-0']")));
		element1.click();
		WebElement element2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='update-menu-btn-0']")));
		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='On Track']")));
		element3.click();

		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[title='Completed'] div[class='ant-select-item-option-content']")));
		element4.click();

		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("p[data-placeholder='Comment about the status']")));
		element5.sendKeys("Ok");
		WebElement element6 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Update']")));
		element6.click();
		driver.close();
	}

	
	public void userCanSetUpFollowupForGoal() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Goals']")));
		element.click();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='goal-create-btn']")));
		element1.click();
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='goal-team']")));
		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("goals_goals_headers_0_goal_title")));
		element3.sendKeys("testing of user can set up followup for goal");

		WebElement element4 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='is-empty is-editor-empty']")));
		element4.sendKeys("testcase");

		Actions action = new Actions(driver);
		for (int i = 0; i < 3; i++) {

			action.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(2000);
		}

		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'yash')]")));
		element5.click();

		WebElement element6 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='goal-submit-btn']")));
		element6.click();

		WebElement element7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[normalize-space()='testing of user can set up followup for goal']")));
		element7.click();

		WebElement element8 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Add a Follow up')]")));
		element8.click();

	WebElement element9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm border-2 border-teal-500 disabled:border-gray-400 relative'] div[class='flex items-center gap-2 justify-center']")));
		element9.click();

		WebElement element10 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("agenda-next")));
		 element10.click();


			WebElement element11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("meeting_meeting_at")));
			element11.click();

			WebElement element12 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-picker-today-btn")));
			element12.click();
			Thread.sleep(3000);
			// Get the current local time

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

			driver.findElement(By.cssSelector("button[type='submit'] div[class='flex items-center gap-2 justify-center']"))
					.click();
	

			WebElement element13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"div[class='relative space-y-2'] button[type='button'] div[class='flex items-center gap-2 justify-center']")));
			element13.click();
			
			WebElement element14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']")));
			element14.click();

			WebElement element15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
					"meeting-save")));
			element15.click();
			
	}

}