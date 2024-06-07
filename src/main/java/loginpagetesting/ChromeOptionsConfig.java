package loginpagetesting;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConfig {
	public static  ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // Applicable to Windows OS
        options.addArguments("--window-size=1920,1080"); // Set window size
        return options;
    }
}

