package TestNGPractice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchWebsiteWithTestNGAssertion {
	WebDriver driver;

	@Test(priority = 1)

	void LaunchEdgeDriver() throws InterruptedException{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		SoftAssert softAssert = new SoftAssert();
		driver.get("https://www.globalsqa.com/demo-site/");
		System.out.println("Printing title of website"+ " : "+ driver.getTitle() );
		String expectedTitle = "Testing Demo Site | Practice Website For Automation - Global SQA";
		String originalTitle = driver.getTitle();
		softAssert.assertEquals(originalTitle, expectedTitle, "Text is mismatch");
		softAssert.assertEquals(originalTitle, "Testing Demo");
		softAssert.assertAll();
		
	}

	@Test(priority = 2)

	void Method2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"post-2715\"]/div[2]/div/div/div[2]/div[1]/ul/li[2]/a")).click();
		driver.quit();
	}
	
		@Test(priority = -1)
		void initialMethod() {
			Reporter.log("TestNG started");
			
		}
		
		@Test(enabled= true)
		void skipTest() {
			
			System.out.println("Skiping test with the help of enabled parameter");
		}
		
		

	}

	

