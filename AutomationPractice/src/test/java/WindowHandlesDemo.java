

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesDemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window -  "+ parentHandle);
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set <String> handles = driver.getWindowHandles();// Set is a return type because we are get multiple windows
		for (String AllChildHandles :handles ) {
			System.out.println(AllChildHandles);
			// To work on child window we have to avoid parent window  so using if block 
			if (!AllChildHandles.equals(parentHandle)) {
				driver.switchTo().window(AllChildHandles);
				driver.findElement(By.id("firstName")).sendKeys("Shweta");
				Thread.sleep(4000);
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle); // To get back to the parent window
		driver.findElement(By.id("name")).sendKeys("Shinde");
		Thread.sleep(3000);
		driver.quit();

	}

}
