package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

	WebDriver driver = null;

	@DataProvider (name = "usercred")
	public String[][] Data(){
		String[][]  cred = new String[2][2];
		cred [0][0] ="xyz";
		cred [0][1] ="123";

		cred[1][0] ="qwe";
		cred[1][1] ="asd";
		return cred;
	}

	@Test (dataProvider = "usercred")
	public void testDataProvider(String id,String pass) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(id);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();

	}
	


}
