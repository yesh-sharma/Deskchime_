package goalpagetesting;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import loginpagetesting.Login;

@Test
public class Goalpage {
	public void goalpage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(10000);
		 driver.findElement(By.cssSelector("button[aria-label='Close']")).click();
		driver.findElement(By.xpath("//span[@class='ant-menu-title-content'][normalize-space()='Goals']")).click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.xpath(
				"//body/div[@id='__next']/div[@class='ant-layout ant-layout-has-sider h-screen']/div[@class='ant-layout lg:ml-60 h-screen']/main[@class='ant-layout-content bg-gray-200 dashboard-screen overflow-auto custom-scrollbar p-4 md:p-6']/div/div[@class='max-w-3xl mx-auto bg-white rounded-md']/div[@class='py-4 px-6 space-y-4']/div[2]"))
				.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("input[placeholder='Eg: Increase my overall productivity']"))
				.sendKeys("Use the SMART goal method");
		driver.findElement(
				By.cssSelector("div[class='tiptap ProseMirror text-sm min-h-[80px] p-3 max-h-80 overflow-y-auto']"))
				.sendKeys(
						"When setting goals for yourself, you may choose to follow the SMART goal method, where you apply specific, measurable, achievable, relevant and time-bound objectives to help you reach your goals.");
		driver.findElement(By.cssSelector("div[class='font-normal text-xs leading-140 text-blue-500 cursor-pointer text-right']")).click();
		 driver.findElement(By.cssSelector(".ant-select-selection-overflow")).click();
	  driver.findElement(By.cssSelector("div[title='Ankit Dhiman'] div[class='ant-select-item-option-content']")).click();
	    
	    WebElement element = driver
				.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	  
	    
	}
}