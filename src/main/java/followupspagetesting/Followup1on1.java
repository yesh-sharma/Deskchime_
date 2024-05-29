package followupspagetesting;

<<<<<<< HEAD
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import loginpagetesting.Login;

public class Followup1on1 {
	@Test
	public void followuppage1on1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();

		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[normalize-space()='1-on-1s']")).click();
		driver.findElement(By.cssSelector("a[data-testid='create-follow-up-button']")).click();


}
}
=======
public class Followup1on1 {
	

}
>>>>>>> e5d21e30503e221b73adac729abd347fd9d185f5
