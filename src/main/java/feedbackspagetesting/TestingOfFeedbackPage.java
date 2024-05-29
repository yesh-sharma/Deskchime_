package feedbackspagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

import loginpagetesting.Login;

@Test
public class TestingOfFeedbackPage {

	public void templateCreation() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();

		// templates
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();

		// create from scratch

		driver.findElement(By.cssSelector(
				"button[class='text-white text-center px-4 py-2 rounded-md border-2 border-teal-500 bg-teal-500']"))
				.click();

		// add title
		driver.findElement(By.id("template_name")).sendKeys("TEST");
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
		driver.findElement(By.xpath("//div[normalize-space()='Submit']")).click();
		driver.close();

	}

	public void userCanMaKEUseOfPreMadeFeedbackTemplate() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();
		driver.findElement(By.xpath("//span[text()='Default Template']")).click();
		driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
		driver.findElement(By.xpath("//div[text()='Use Template']")).click();
		driver.findElement(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")).click();
		driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='feedback-team-select']")).click();
		driver.findElement(By.cssSelector(".ant-select-item-option-content")).click();
		Actions actions1 = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("button[data-testid='feedback-permission-next-btn']"));
		actions1.moveToElement(element);
		actions1.perform();
		element.click();

		driver.findElement(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")).click();
		driver.close();
	}

	public void userCanAskForFeedbackFromSpecificTeamMember() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();
		driver.findElement(By.xpath("//span[text()='Default Template']")).click();
		driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
		driver.findElement(By.xpath("//div[text()='Use Template']")).click();
		driver.findElement(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")).click();
		driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='feedback-switch-teams-members']")).click();
		driver.findElement(By.cssSelector(".ant-select-selection-overflow")).click();
		driver.findElement(By.cssSelector("div[title='Yesh Sharma'] div[class='ant-select-item-option-content']"))
				.click();
		Actions actions1 = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("button[data-testid='feedback-permission-next-btn']"));
		actions1.moveToElement(element);
		actions1.perform();
		element.click();

		driver.findElement(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")).click();
		driver.close();

	}

	public void userCanAskForFeedbackFromWholeTeam() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[data-testid='feedback-templates-btn']")).click();
		driver.findElement(By.xpath("//span[text()='Default Template']")).click();
		driver.findElement(By.cssSelector("div[class='flex flex-1 justify-center'] ")).click();
		driver.findElement(By.xpath("//div[text()='Use Template']")).click();
		driver.findElement(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")).click();
		driver.findElement(By.xpath("//button[@data-testid='question-next-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='feedback-team-select']")).click();
		driver.findElement(By.cssSelector(".ant-select-item-option-content")).click();
		Actions actions1 = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("button[data-testid='feedback-permission-next-btn']"));
		actions1.moveToElement(element);
		actions1.perform();
		element.click();

		driver.findElement(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")).click();
		driver.close();
	}

	public void usersCanSeeAllTheFeedbackTheyHaveReceived() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();
		driver.findElement(By.xpath("//span[text()='Received']")).click();
		driver.close();

	}

	public void userCanShortAndFilterFeedbackByPending() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();

		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();

		driver.findElement(By.xpath("//span[text()='Received']")).click();
		driver.findElement(By.cssSelector("span[title='All']")).click();
		driver.findElement(By.cssSelector("div[title='Pending'] div[class='ant-select-item-option-content']")).click();
		driver.close();

	}

	public void userCanShortAndFilterFeedbackByAnswered() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

		login.avoidFeedbackpopup();
		driver.findElement(By.xpath("//span[text()='Feedbacks']")).click();

		driver.findElement(By.xpath("//span[text()='Received']")).click();

		driver.findElement(By.cssSelector("span[title='All']")).click();
		driver.findElement(By.cssSelector("div[title='Answered'] div[class='ant-select-item-option-content']")).click();
		driver.close();

	}

}