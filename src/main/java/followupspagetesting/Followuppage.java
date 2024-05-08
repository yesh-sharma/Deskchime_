package followupspagetesting;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.Login;

public class Followuppage {
	@Test
	public void followuppage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ant-modal-close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		driver.findElement(By.xpath("//span[normalize-space()='Follow Ups']")).click();
		driver.findElement(
				By.cssSelector(".text-white.text-center.px-4.py-2.rounded-md.border-2.border-teal-500.bg-teal-500"))
				.click();

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

			driver.findElement(By.cssSelector(
					"div[class='bg-slate-50 rounded-md p-2 space-y-2 max-h-48 overflow-y-auto custom-scrollbar'] div:nth-child(1) div:nth-child(1)"))
					.click();

		} else if (hour == 10 && minute >= 30 && minute <= 59) {

			driver.findElement(By.cssSelector(
					"body > div:nth-child(42) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)"))
					.click();

		} else if (hour == 11 && minute >= 1 && minute < 29) {

			driver.findElement(By.cssSelector("div[class='ant-form-item space-y-2'] div:nth-child(3) div:nth-child(1)"))
					.click();

		} else if (hour == 11 && minute >= 30 && minute < 59) {

			driver.findElement(By.cssSelector("div[class='bg-slate-50 rounded-md p-2 space-y-2 max-h-48 overflow-y-auto custom-scrollbar'] div:nth-child(1) div:nth-child(1)")).click();
					

		} else if (hour == 12 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"body > div:nth-child(44) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5)"))
					.click();

		} else if (hour == 12 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector(
					"body > div:nth-child(44) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1)"))
					.click();
		} else if (hour == 13 && minute >= 1 && minute < 29) {

			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();
		} else if (hour == 13 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();

		} else if (hour == 14 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();

		} else if (hour == 14 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200']"))
					.click();

		} else if (hour == 15 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();

		} else if (hour == 15 && minute >= 30 && minute < 59) {

			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();

		} else if (hour == 16 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200']"))
					.click();
		} else if (hour == 16 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector("div:nth-child(14) div:nth-child(1)")).click();

		} else if (hour == 17 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();
		} else if (hour == 17 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200'] div[class='text-slate-900 font-normal text-base leading-140']"))
					.click();
		} else if (hour == 18 && minute >= 1 && minute < 29) {
			driver.findElement(By.cssSelector(
					"div[class='border border-slate-300 px-4 py-2 rounded-md hover:bg-gray-200 cursor-pointer bg-gray-200']"))
					.click();
		} else if (hour == 18 && minute >= 30 && minute < 59) {
			driver.findElement(By.cssSelector("div:nth-child(18) div:nth-child(1)")).click();
		}
		driver.findElement(By.cssSelector("button[type='submit'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(
				"body > div:nth-child(46) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)"))
				.click();
		driver.findElement(By.cssSelector(
				"div[class='relative space-y-2'] button[type='button'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();

	}

}
