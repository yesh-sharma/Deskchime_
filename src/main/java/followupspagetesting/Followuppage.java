package followupspagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(10000);
//		driver.findElement(By.cssSelector("button[aria-label='Close']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='Follow Ups']")).click();
		driver.findElement(
				By.cssSelector(".text-white.text-center.px-4.py-2.rounded-md.border-2.border-teal-500.bg-teal-500"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.findElement(By.cssSelector("td[title='2024-04-18'] div[class='ant-picker-cell-inner']")).click();
		driver.findElement(By.cssSelector(
				"div[class='bg-slate-50 rounded-md p-2 space-y-2 max-h-48 overflow-y-auto custom-scrollbar'] div:nth-child(1) div:nth-child(1)"))
				.click();
		driver.findElement(By.cssSelector("button[type='submit'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(".font-normal.text-xs.leading-140.text-blue-500.cursor-pointer.text-right"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
		//select member
		
		driver.findElement(By.cssSelector(".font-normal.text-xs.leading-140.text-blue-500.cursor-pointer.text-right")).click();
		driver.findElement(By.cssSelector(".ant-select-selection-overflow")).click();
		driver.findElement(By.cssSelector("div[title='yash'] div[class='ant-select-item-option-content']")).click();
		driver.findElement(By.cssSelector(".ant-select-selection-overflow")).click();
		driver.findElement(By.cssSelector(
				"div[class='relative space-y-4 pt-3'] button[type='button'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative']"))
				.click();
	}

}
