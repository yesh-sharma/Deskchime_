package loginpagetesting;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class Testingofloginpage {

	@FindBy(css = "input[placeholder='Email address']")
	WebElement useremail;

	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordEle;

	@FindBy(css = "button[type='submit']")
	WebElement submit;

	@Test(dataProvider="getData")
	public void validcredendetials(HashMap<String,String> input) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Login log =new Login(driver);
	    log.Goto();
	    log.loginApplication(input.get("email"), input.get("password"));
	}
   
	@DataProvider
	 public Object [][] getData() {
		 HashMap <String,String> map =new HashMap<String,String>();
		 map.put("email", "yeshsharma516032@gmail.com");
		 map.put("password", "Yesh1234");
		 HashMap <String,String> map1 =new HashMap<String,String>();
		 map1.put("email", "yesh@zasyasolutions.com");
		 map1.put("password", "Yesh255198@");
		 return new Object[][] {{map},{map1}};
		 
		 
	 }
	public void invalidcredentials1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://deskchime.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
		
		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolution.com");
		passwordEle.sendKeys("Yesh255198@");
		submit.click();
		
		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);
			driver.close();

		}

	}

	public void invalidcredentials2() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
	
		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolutions.com");
		passwordEle.sendKeys("Yesh2551981@");
		submit.click();
	
		WebElement w1 = driver.findElement(By.cssSelector(".ant-notification-notice-message"));

		if (w1.isDisplayed()) {
			String dialogText = w1.getText();
			System.out.println("Popup message: " + dialogText);
			driver.close();

		}

	}

	public void emptyusernamefield() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
	
		PageFactory.initElements(driver, this);
		useremail.sendKeys("yeshsharma516032@gmail.com");

		submit.click();
		System.out.println("popup message" + driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		driver.close();

	}

	public void emptypasswordfield() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
	
		PageFactory.initElements(driver, this);

		passwordEle.sendKeys("Yesh2551981@");
		submit.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']")).getText());
		driver.close();
	}

	public void passwordresetlink() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[type='button'] div[class='flex items-center gap-2 justify-center']"))
				.click();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("yesh@zasyasolutions.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement dialog = driver.findElement(By.xpath(
				"//div[@class='ant-notification-notice ant-notification-notice-success css-3mqfnx ant-notification-notice-closable']"));
		if (dialog.isDisplayed()) {
			String dialogText = dialog.getText();
			System.out.println("Popup message: " + dialogText);
			driver.close();
		}
	}

	public void userlogout() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deskchime.com/");
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[3]/div/button[5]/div")).click();
	
	
		PageFactory.initElements(driver, this);
		useremail.sendKeys("yesh@zasyasolutions.com");
		passwordEle.sendKeys("Yesh255198@");
		submit.click();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement feedbackPopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Feedbacks']")));
            feedbackPopup.click();
        } catch (Exception e) {
          e.printStackTrace();
         System.out.println("here the error" + e);
        }
		driver.findElement(By.xpath(
				"//button[@class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default text-slate-600 hover:text-teal-500 active:text-teal-600 disabled:text-zinc-400 h-12 p-3 text-base relative']//div[1]"))
				.click();

		driver.close();
	}
	
	}

 