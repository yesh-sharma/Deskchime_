package settingpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import loginpagetesting.Login;

public class Settingpage {
	@Test
public void testingOfSettingPage() throws InterruptedException {
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
}
}

