package feedbackspagetesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginpagetesting.ChromeOptionsConfig;
import loginpagetesting.Login;
import retryanalyzer.RetryAnalyzer;

import org.openqa.selenium.Keys;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestingOfFeedbackPage {
	
	 private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	        // Set the desired capabilities for the browser you want to use
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setBrowserName("chrome");

	        // URL of the remote Selenium server or Selenium Grid hub
	        URL remoteUrl = new URL("http://localhost:4444/wd/hub");

	        // Initialize the RemoteWebDriver with the remote URL and desired capabilities
	        driver.set(new RemoteWebDriver(remoteUrl, capabilities));
	        
	        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        getDriver().manage().window().maximize();
	    }
	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	        driver.remove();
	    }

	    private WebDriver getDriver() {
	        return driver.get();
	    }
	    
	    
	    
	    
	    
	
@Test
	public void templateCreation() throws InterruptedException {

		 WebDriver driver = getDriver();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		// templates
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element2.click();

		// create from scratch
		WebElement element3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='create-template']")));
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
		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Submit']")));
		element5.click();

		

	}

	public void userCanMaKEUseOfPreMadeFeedbackTemplate() throws InterruptedException {
		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();
		WebElement element11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Default Template']")));
		element11.click();

		WebElement element12 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='flex flex-1 justify-center']")));
		element12.click();

		WebElement element13 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Use Template']")));
		element13.click();

		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));

		element2.click();

		Actions actions1 = new Actions(driver);
		WebElement element21 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='question-next-btn']")));

		actions1.moveToElement(element21);
		actions1.scrollToElement(element21);

		actions1.perform();
		element21.click();

		WebElement element3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
		element3.click();
		Thread.sleep(2000);

		WebElement element4 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
		actions1.moveToElement(element4);
		actions1.perform();
		element4.click();

		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));

		actions1.moveToElement(element5);
		actions1.perform();
		element5.click();
	
	}

	public void userCanAskForFeedbackFromSpecificTeamMember() throws InterruptedException {
		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();

		WebElement element11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Default Template']")));
		element11.click();

		WebElement element12 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='flex flex-1 justify-center']")));
		element12.click();

		WebElement element13 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Use Template']")));
		element13.click();

		Actions actions1 = new Actions(driver);
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));

		actions1.moveToElement(element2);
		actions1.perform();
		element2.click();
		WebElement element21 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='question-next-btn']")));
		actions1.moveToElement(element21);
		actions1.perform();
		element21.click();

		WebElement element3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[data-testid='tab-button-Select Team']")));

		element3.click();
		WebElement element33 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='qa']")));
		element33.click();

		WebElement element4 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
		element4.click();

		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
		actions1.moveToElement(element5);
		actions1.perform();
		element5.click();

		WebElement element6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
		actions1.moveToElement(element6);
		actions1.perform();
		element6.click();

		

	}

	public void userCanAskForFeedbackFromWholeTeam() throws InterruptedException {
		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();

		WebElement element11 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element11.click();

		WebElement element12 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Default Template']")));
		element12.click();

		WebElement element13 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='flex flex-1 justify-center']")));
		element13.click();

		WebElement element14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Use Template']")));
		element14.click();

		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));
		element2.click();
		Actions actions1 = new Actions(driver);
		WebElement element21 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='question-next-btn']")));
		actions1.moveToElement(element21);
		actions1.perform();
		element21.click();

		WebElement element3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[data-testid='tab-button-Select Team']")));

		element3.click();
		WebElement element33 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='qa']")));
		element33.click();

		WebElement element4 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-0']")));
		element4.click();

		//WebElement element44 = wait.until(
		//		ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='memberList-1']")));
		//element44.click();

		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
		actions1.moveToElement(element5);
		actions1.perform();
		element5.click();

		WebElement element6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
		actions1.moveToElement(element6);
		actions1.perform();
		element6.click();

	

	}

	public void usersCanSeeAllTheFeedbackTheyHaveReceived() throws InterruptedException {
		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		

	}

	public void userCanShortAndFilterFeedbackByPending() throws InterruptedException {

		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='All']")));
		element3.click();
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[title='Pending'] div[class='ant-select-item-option-content']")));
		element4.click();
	

	}

	public void userCanShortAndFilterFeedbackByAnswered() throws InterruptedException {
		 WebDriver driver = getDriver();

		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		element1.click();
		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='All']")));
		element3.click();
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[title='Answered'] div[class='ant-select-item-option-content']")));
		element4.click();

		

	}

	
	public void userCanAskForFeedbackByExternalLink() throws InterruptedException {
		 WebDriver driver = getDriver();
		Login login = new Login(driver);
		login.Goto();
		login.loginApplication("yesh@zasyasolutions.com", "Yesh255198@");

		login.avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Feedbacks']")));
		element.click();

		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element1.click();

		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a[data-testid='feedback-templates-btn']")));
		element2.click();

		WebElement element3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Default Template']")));
		element3.click();

		WebElement element4 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='flex flex-1 justify-center']")));
		element4.click();

		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Use Template']")));
		element5.click();

		WebElement element6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-testid='feedback-scratch-next-btn']")));
		element6.click();
		Actions actions1 = new Actions(driver);
		WebElement element7 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='question-next-btn']")));
		actions1.moveToElement(element7);
		actions1.perform();
		element7.click();

		WebElement element8 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-outside-btn']")));
		element8.click();

		WebElement element9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='feedback-emails-input']")));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].value='yeshsharma516032@gmail.com';", element9);

		    // Alternatively, use Actions to send keys
		    Actions actions2 = new Actions(driver);
		    actions2.moveToElement(element9).click().sendKeys("yeshsharma516032@gmail.com").perform();

		    // Debugging: Print out the input field value
		    System.out.println("Input field value: " + element9.getAttribute("value"));
		    Actions actions = new Actions(driver);

			// Move the mouse to the specific coordinates and perform click
			actions.moveByOffset(0, 500).click().perform();
		   
			
			element8.click();
		    
		    WebElement element10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-emails-add-btn']")));
            element10.click();
            WebElement element11 = wait.until(ExpectedConditions
    				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-permission-next-btn']")));
    		actions1.moveToElement(element11);
    		actions1.perform();
    		element11.click();

    		WebElement element12= wait.until(ExpectedConditions
    				.visibilityOfElementLocated(By.cssSelector("button[data-testid='feedback-preview-submit-btn']")));
    		actions1.moveToElement(element12);
    		actions1.perform();
    		element12.click();

	}
}