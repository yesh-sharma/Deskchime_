package loginpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {

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
		driver.manage().deleteAllCookies();
		driver.get("https://deskchime.com/");
		driver.findElement(By.cssSelector("a[data-testid='login-btn']")).click();
		ChromeOptions option = new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.NONE);
		option.addArguments("--disable-features=NetworkService");
		option.addArguments("--dns-prefetch-disable");
		option.addArguments("--disable-extensions");
		option.addArguments("--blink-settings=imagesEnabled=false");

	}

	public void avoidFeedbackpopup() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	
			WebElement FeedbackPopup1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ant-modal-close']")));
			if( FeedbackPopup1.isDisplayed())
			{	Actions actions = new Actions(driver);

			// Move the mouse to the specific coordinates and perform click
			actions.moveByOffset(0, 50).click().perform();
			}
			else {
				System.out.println("No feedback popup shown");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

	}

}
