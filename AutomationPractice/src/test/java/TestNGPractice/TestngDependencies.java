package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngDependencies {
	WebDriver driver;

	@Test(dependsOnMethods = {"initialMethod"}, groups= {"Launch"})

	void LaunchEdgeDriver() throws InterruptedException{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/");
		System.out.println("Printing title of website"+ " : "+ driver.getTitle() );



	}

	@Test(priority = 2, groups = {"click after launch"})

	void Method2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"post-2715\"]/div[2]/div/div/div[2]/div[1]/ul/li[2]/a")).click();
		driver.quit();
	}

	@Test(priority = -1, groups = {"Deisclamer"})
	void initialMethod() {
		Reporter.log("TestNG started");

	}

	@Test(enabled= true, priority = 3, groups = {"Skipping"})
	void skipTest() {

		System.out.println("Skiping test with the help of enabled parameter");
	}




}
