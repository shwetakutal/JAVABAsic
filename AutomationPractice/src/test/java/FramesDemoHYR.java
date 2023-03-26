import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemoHYR {
	public WebDriver driver;
	@ Test()
	public void launchWebsite() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		System.out.println("Printing title of website"+ " : "+ driver.getTitle() );
		driver.findElement(By.id("name")).sendKeys("High");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.switchTo().frame(driver.findElement(By.id("frm1")));

		Select courseId = new Select (driver.findElement(By.id("selectnav2")));
		courseId.selectByVisibleText("Home");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("HighagainWithFrame3");

		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		Thread.sleep(4000);
		driver.findElement(By.id("name")).sendKeys("Highagain with main web page");
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}



