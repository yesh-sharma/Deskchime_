package feedbackspagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import loginpagetesting.Login;

public class TestingOfFeedbackPage {
@Test
	public void templateCreation() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
//      explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[aria-label='Close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		driver.findElement(By.xpath("//span[normalize-space()='Feedbacks']")).click();

		// templates
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[1]/div[2]/button[1]")).click();

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

	public void saveandEdittemplate() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
//      explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[aria-label='Close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		driver.findElement(By.xpath("//span[normalize-space()='Feedbacks']")).click();

		// templates
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[1]/div[2]/button[1]")).click();
//		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement clc = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//td[@class='ant-table-cell ant-table-cell-row-hover']//button[@class='tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default text-teal-700 border-2 hover:border-teal-700 hover:text-teal-700 active:bg-teal-500 active:text-white disabled:border-zinc-400 disabled:text-zinc-400 px-3 py-2 text-sm rounded-full leading-none ant-dropdown-trigger border-slate-300 w-9 h-9 md:w-9 md:h-9 relative']")));
		clc.click();

	}

	
	public void userCanMaKEUseOfPreMadeFeedbackTemplate() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[aria-label='Close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		driver.findElement(By.xpath("//span[normalize-space()='Feedbacks']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[1]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/button")).click();

	}


	

	public void userCanAskForFeedbackFromSpecificTeamMember() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
	}

	public void userCanAskForFeedbackFromWholeTeam() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");

	}

	public void teamMembersGetnotifiedAboutFeedbackRequest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
	}

	public void usersCanseeAllTheFeedbackTheyHaveReceived() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
	}

	public void userCanShortAndFilterFeedbackByDate() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yeshsharma516032@gmail.com", "Yesh12345");
	}

}