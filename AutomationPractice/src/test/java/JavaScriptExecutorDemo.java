import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());

		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("alert('Hi')");
		//		Thread.sleep(5000);
		//		System.out.println("alert executed");
		//		driver.quit();


		driver.findElement(By.name("q")).sendKeys("selenium"+"\n");
		Thread.sleep(9000);
		String str = driver.findElement(By.xpath("//input[@name='q']")).getText();
		System.out.println(str);
		
		String [] s=str.split("\n");
		System.out.println(s.length);
		System.out.println("execution done");




	}

}
