package settingpagetesting;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import loginpagetesting.Login;

public class Settingpage {
	@Test
	public void userCreatedAndDeletedSuccessfully() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		
		login.avoidFeedbackpopup();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Settings']")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();

		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentwindowId = it.next();
		String childwindowid = it.next();
		driver.switchTo().window(childwindowid);
		driver.get("https://temp-mail.org/en/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[id='click-to-copy']")).click();
		driver.switchTo().window(parentwindowId);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.id("first_name")).sendKeys("ankit joseph");
		WebElement ele = driver.findElement(By.id("email"));

		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().keyDown(Keys.CONTROL).sendKeys(Keys.chord("v")).build().perform();

		driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']")).click();
		driver.findElement(By.cssSelector("div[title='qa']")).click();
		driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']")).click();
		driver.findElement(By.id("role")).click();
		driver.findElement(By.cssSelector("div[title='Manager']")).click();

		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		driver.findElement(By.cssSelector(
//				"td[class='ant-table-cell ant-table-cell-row-hover'] button[class='tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default text-teal-700 border-2 hover:border-teal-700 hover:text-teal-700 active:bg-teal-500 active:text-white disabled:border-zinc-400 disabled:text-zinc-400 px-3 py-2 text-sm rounded-full leading-none ant-dropdown-trigger border-slate-300 w-9 h-9 md:w-9 md:h-9 relative']"))
//				.click();
//
//		driver.findElement(By.cssSelector("span[class='ant-dropdown-menu-title-content'] span")).click();
//		driver.findElement(By.cssSelector("button[class='ant-btn ant-btn-primary ant-btn-sm'] span")).click();
//		driver.close();
	}
}
