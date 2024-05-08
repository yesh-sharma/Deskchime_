package feedbackspagetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import loginpagetesting.Login;

public class TestingOfFeedbackPage {
@Test
	public void templateCreation() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.NONE);
		option.addArguments("--disable-features=NetworkService");
		option.addArguments("--dns-prefetch-disable");
		option.addArguments("--disable-extensions");
		 option.addArguments("--blink-settings=imagesEnabled=false");
		 
		//option.setProxy(proxy);
		WebDriver driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement feedbackPopup = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']")));
			feedbackPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("here the error :" + e);
		}

		driver.findElement(By.xpath("//span[normalize-space()='Feedbacks']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[1]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/main/div/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/button"))
				.click();
		driver.findElement(By.cssSelector("a[href='/opencart/template/edit/03b1562a-97e6-43a3-a63b-a85ff14f85b7']"))
				.click();
		driver.findElement(By.cssSelector("#template_description")).sendKeys("1212");
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();

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
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/main/div/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/button"))
				.click();
		driver.findElement(By.cssSelector("span[class='ant-dropdown-menu-title-content'] div")).click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']")).click();
		driver.findElement(By.cssSelector(".ant-select-item-option-content")).click();
		Actions actions = new Actions(driver);

		// Find a specific element on the page
		WebElement element = driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"));

		// Scroll to the element
		actions.moveToElement(element);
		actions.perform();
		element.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
	}

	public void userCanAskForFeedbackFromSpecificTeamMember() throws InterruptedException {

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
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/main/div/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/button"))
				.click();
		driver.findElement(By.cssSelector("span[class='ant-dropdown-menu-title-content'] div")).click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(".font-normal.text-xs.leading-140.text-blue-500.cursor-pointer.text-right"))
				.click();
		driver.findElement(By.cssSelector(".ant-select-selection-overflow")).click();
		driver.findElement(By.cssSelector("div[title='Yesh Sharma'] div[class='ant-select-item-option-content']"))
				.click();

		Actions actions = new Actions(driver);

		// Find a specific element on the page
		WebElement element = driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"));

		// Scroll to the element
		actions.moveToElement(element);
		actions.perform();
		element.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();

	}

	public void userCanAskForFeedbackFromWholeTeam() throws InterruptedException {

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
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/main/div/div[3]/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/button"))
				.click();
		driver.findElement(By.cssSelector("span[class='ant-dropdown-menu-title-content'] div")).click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
		driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']")).click();
		driver.findElement(By.cssSelector(".ant-select-item-option-content")).click();
		Actions actions = new Actions(driver);

		// Find a specific element on the page
		WebElement element = driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"));

		// Scroll to the element
		actions.moveToElement(element);
		actions.perform();
		element.click();
		driver.findElement(By.cssSelector(
				"button[class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative'] div[class='flex items-center gap-2 justify-center']"))
				.click();
	}

	
	public void usersCanSeeAllTheFeedbackTheyHaveReceived() throws InterruptedException {
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
		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)"))
				.click();

	}
	
	
	public void userCanShortAndFilterFeedbackByPending() throws InterruptedException {
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
		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)"))
				.click();
		driver.findElement(By.cssSelector("span[title='All']")).click();
		driver.findElement(By.cssSelector("div[title='Pending'] div[class='ant-select-item-option-content']")).click();
	}


public void userCanShortAndFilterFeedbackByAnswered() throws InterruptedException {
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
	driver.findElement(By.cssSelector(
			"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)"))
			.click();
	driver.findElement(By.cssSelector("span[title='All']")).click();
	driver.findElement(By.cssSelector("div[title='Answered'] div[class='ant-select-item-option-content']")).click();

}

}