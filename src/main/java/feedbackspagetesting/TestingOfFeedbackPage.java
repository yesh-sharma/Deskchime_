package feedbackspagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;
import loginpagetesting.Login;

@Test 
public class TestingOfFeedbackPage {

	public void templateCreation() throws InterruptedException {

		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		// templates
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element2.click();

		// create from scratch
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='create-template']")));
				element3.click();
		
		// add title
				
				WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("template_name")));
		element4.sendKeys("TEST");
		// add description
		driver.findElement(By.id("template_description")).sendKeys("test the feebacksection");

		// click
		
		
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative']"))
				.click();
		// click on multiple choice
		driver.findElement(By.cssSelector(
				"span[class='ant-select-selection-item'] div[class='font-normal text-xs lg:text-sm leading-140 lg:leading-140 text-slate-600']"))
				.click();

		driver.findElement(By.cssSelector("input[placeholder='E.g. What would you like to ask from a person.']"))
				.sendKeys("anything");

		driver.findElement(By.xpath("//input[@placeholder='E.g. Option 1']")).sendKeys("true");
		driver.findElement(By.xpath("//input[@placeholder='E.g. Option 2']")).sendKeys("false");
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Submit']")));
		element5.click();
		
		driver.close();

	}

	public void userCanMaKEUseOfPreMadeFeedbackTemplate() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();
		
		driver.findElement(By.xpath("//span[text()='Default Template']")).click();
		driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
		
		
		driver.findElement(By.xpath("//div[text()='Use Template']")).click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));
		element2.click();

		driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();
		Thread.sleep(2000);
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
		element3.click();
		Actions actions1 = new Actions(driver);
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
		actions1.moveToElement(element4);
		actions1.perform();
		element4.click();
		
		WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
	    element5.click();
	
		
		driver.close();
	}

	public void userCanAskForFeedbackFromSpecificTeamMember() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();
		
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();
		
		driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();
		driver.findElement(By.xpath("//span[text()='Default Template']")).click();
		driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
		
		driver.findElement(By.xpath("//div[text()='Use Template']")).click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));
		element2.click();
		
		driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();
	
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='tab-button-Select Team']")));
		
		element3.click();
		WebElement element33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='qa']")));
		element33.click();
		
		
		
		
		WebElement element4= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
		element4.click();
		
		
		
		Actions actions1 = new Actions(driver);
		WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
		actions1.moveToElement(element5);
		actions1.perform();
		element5.click();
		
		WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
	    element6.click();
	
		
		driver.close();

	}

	public void userCanAskForFeedbackFromWholeTeam() throws InterruptedException {
	WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();

	Login login = new Login(driver);
	login.Goto();
	login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

	login.avoidFeedbackpopup();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
	element.click();
	
	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
	element1.click();
	
	driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();
	driver.findElement(By.xpath("//span[text()='Default Template']")).click();
	driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
	
	driver.findElement(By.xpath("//div[text()='Use Template']")).click();
	WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));
	element2.click();
	
	driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();

	WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='tab-button-Select Team']")));
	
	element3.click();
	WebElement element33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='qa']")));
	element33.click();
	
	
	
	
	WebElement element4= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
	element4.click();
	
	WebElement element44= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-1']")));
	element44.click();
	
	
	Actions actions1 = new Actions(driver);
	WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
	actions1.moveToElement(element5);
	actions1.perform();
	element5.click();
	
	WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
    element6.click();

	
	driver.close();
		
	}

	public void usersCanSeeAllTheFeedbackTheyHaveReceived() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		driver.close();

	}

	public void userCanShortAndFilterFeedbackByPending() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='All']")));
		element3.click();
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Pending'] div[class='ant-select-item-option-content']")));
		element4.click();
		driver.close();

	}

	public void userCanShortAndFilterFeedbackByAnswered() throws InterruptedException {
		WebDriver driver = new ChromeDriver(ChromeOptionsConfig.getChromeOptions());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

	
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='All']")));
		element3.click();
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Answered'] div[class='ant-select-item-option-content']")));
		element4.click();
		
		driver.close();

	}

}