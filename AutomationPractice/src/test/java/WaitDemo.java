import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo {

	public static void main(String[] args) {



		//implicitWait( );
		explicitWait( );
	}

	private static void explicitWait() {

		WebDriver driver = new FirefoxDriver( );
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("scrolltest" + Keys.ENTER);


//		Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		 

//	        wait.until(ExpectedConditions. elementToBeClickable(By.xpath("//a/h3")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println(((WebElement) wait).getText( ));

	}

	private static void implicitWait1() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://reqres.in/api/users?delay=9");
		System.out.println(driver.getPageSource());
	}





}




