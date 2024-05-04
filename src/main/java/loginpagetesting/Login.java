package loginpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	WebDriver driver;

	public  Login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

		
		
		
	}



//page factory
	
	
	@FindBy(css = "input[placeholder='Email address']")
	WebElement useremail;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordEle;

	@FindBy(css = "button[type='submit']")
	WebElement submit;

	public void loginApplication(String email, String password) throws InterruptedException {
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();

		
	}

	public void Goto() {
		driver.get("https://deskchime.com/");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

}
