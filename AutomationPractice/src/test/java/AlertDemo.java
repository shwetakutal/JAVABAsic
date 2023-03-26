

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	public WebDriver driver;
	@Test()

	public void LaunchChromeDriver() throws Exception{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		//		Thread.sleep(3000);
		//		driver.findElement(By.id("alertBox")).click();
		//		Alert simpleAlert = driver.switchTo().alert();
		//		System.out.println(simpleAlert.getText());
		//		Thread.sleep(3000);
		//		simpleAlert.accept();
		//		Thread.sleep(3000);
	}

	// Simple Alert

	@Test()

	public void SimpleAlert() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.id("alertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(3000);
		simpleAlert.accept();
		//		Thread.sleep(3000);
		//		driver.quit();

	}
	@Test()
	// Confirmation Alert
	public void ConfirmationAlert() throws Exception {
		
		Thread.sleep(3000);
		driver.findElement(By.id("confirmBox")).click();
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println(confirmationAlert.getText());
		Thread.sleep(3000);
		confirmationAlert.dismiss();
		Thread.sleep(3000);
		driver.quit();
		//		System.out.println(driver.findElement(By.id("output")).getText());

	}

}
