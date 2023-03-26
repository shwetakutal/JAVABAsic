import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframesDemo2LetCode {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/frame");
		System.out.println(driver.getTitle());
//		Thread.sleep(3000);
		driver.switchTo().frame("firstFr");//frame(driver.findElement(By.name("fname")).sendKeys("SHWETA"));
		driver.findElement(By.name("fname")).sendKeys("SHWETA");
//		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.name("email")).sendKeys("shwetakshinde30@gmail.com");
//		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("SHINDE");
//		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Watch tutorial")).click();
//		Thread.sleep(3000);
		driver.quit();
	}

}
