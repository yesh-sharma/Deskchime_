package followupspagetesting;

import java.time.Duration;
import java.time.LocalTime;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.Login;

@Test
public class Followuppage {

	public void followuppage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[normalize-space()='Follow Ups']")).click();
		driver.findElement(By.cssSelector("a[data-testid='create-follow-up-button']")).click();

		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2) > div:nth-child(1)"))
				.click();

		driver.findElement(By.cssSelector("#meeting_meeting_title")).sendKeys("followup functionality");

		driver.findElement(
				By.cssSelector("div[class='tiptap ProseMirror text-sm min-h-[80px] p-3 max-h-80 overflow-y-auto']"))
				.sendKeys("user interface");
		driver.findElement(By.cssSelector("button[type='submit'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.id("meeting_meeting_at")).click();
		driver.findElement(By.cssSelector(".ant-picker-today-btn")).click();
		Thread.sleep(2000);
		// Get the current local time

		LocalTime currentTime = LocalTime.now();
		// Extract hour and minute components
		int hour = currentTime.getHour();
		int minute = currentTime.getMinute();
		System.out.println(hour);
		System.out.println(minute);
		// Print the hour and minute

		if (hour == 10 && minute >= 1 && minute <= 29) {

			driver.findElement(By.xpath("//div[text()='11:00 M']")).click();

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
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div[data-testid='memberList-0']")).click();
		driver.findElement(By.cssSelector(
				"div[class='relative space-y-2'] button[type='button'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();

		driver.close();
	}

	public void meetingWithoutSpecifyDateAndTime() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		// explicit wait

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ant-modal-close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		// click on follow up
		driver.findElement(By.xpath("//span[normalize-space()='Follow Ups']")).click();
		driver.findElement(By.cssSelector("a[data-testid='create-follow-up-button']")).click();

		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2) > div:nth-child(1)"))
				.click();

		driver.findElement(By.cssSelector("#meeting_meeting_title")).sendKeys("followup functionality");

		driver.findElement(
				By.cssSelector("div[class='tiptap ProseMirror text-sm min-h-[80px] p-3 max-h-80 overflow-y-auto']"))
				.sendKeys("user interface");
		driver.findElement(By.cssSelector("button[type='submit'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.id("meeting_meeting_at")).click();
		driver.findElement(By.xpath("//div[text()='Close']")).click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		WebElement w1 = driver.findElement(By.xpath("//div[text()='Please select meeting time or members']"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);
			driver.close();

		}
	}

}