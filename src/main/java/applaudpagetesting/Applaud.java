
package applaudpagetesting;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basetest.BaseTest;


@Test
public class Applaud extends BaseTest {

	public Applaud() {
		super(); // This will initialize the WebDriver in the BaseTest class
	}

	@Test
	public void sendApplaud() throws InterruptedException {

		Goto();

		loginApplication();

		//avoidFeedbackpopup();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement applaudButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));

		applaudButton.click();

		WebElement createApplaud = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//button[@class='rounded-lg w-fit tracking-[0.5px] font-medium flex items-center gap-2 justify-center transition-all duration-200 ease-in-out disabled:cursor-default bg-teal-500 text-white hover:bg-teal-400 active:bg-teal-300 disabled:bg-zinc-400 h-10 px-3 py-2 text-sm relative']")));
		createApplaud.click();

		WebElement memberNameList = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_id']")));
		memberNameList.click();

		WebElement memberName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Ankit Sharma']")));

		memberName.click();
		
		

		WebElement categoriesField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-selection-overflow']")));
		categoriesField.click();
		
		
		WebElement summarizer= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='The one who links, restates, concludes, and summarizes.']")));
		summarizer.click();
		categoriesField.click();

		WebElement comment = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='comment']")));
		comment.sendKeys("ok");
		
		
		WebElement submitButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		submitButton.click();

	}

	public void useMonthFilter() throws InterruptedException {

		Goto();

		loginApplication();

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement applaudbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		applaudbutton.click();
		WebElement selectMonth = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select month']")));
		selectMonth.click();
		WebElement april = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Apr']")));
		april.click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[text()='Apr 22, 2024']")).getText());

	}

	public void seeReceivedApplauds() throws InterruptedException {

		Goto();

		loginApplication();

		avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement applaudbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		applaudbutton.click();
		WebElement RecievedButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Received']")));
		RecievedButton.click();

	}

	public void seeSentApplauds() throws InterruptedException {

		Goto();

		loginApplication();

		avoidFeedbackpopup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement applaudButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Applaud']")));
		applaudButton.click();

		WebElement SentApplaudButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sent']")));

		SentApplaudButton.click();

	}
}