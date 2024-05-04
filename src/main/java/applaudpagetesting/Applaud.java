package applaudpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.Login;

public class Applaud {
	@Test
	public void applaud() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");
//		 explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
				WebElement feedbackPopup = wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Feedbacks']")));
				feedbackPopup.click();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("here the error" + e);
			}
		
		driver.findElement(By.xpath("/html/body/div/div/aside/div/div/div[2]/ul/li[5]")).click();
	
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
}
