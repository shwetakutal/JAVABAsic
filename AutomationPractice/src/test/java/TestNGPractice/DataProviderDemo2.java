package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo2 {
	WebDriver driver;

	@Test (priority =1 )
	public void launchWebsite() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		System.out.println("Printing title of website"+ " : "+ driver.getTitle() );
	}

	// To use data provider from different class extra -dataProviderClass has to be given

	//	@Test(priority = 2,dataProvider =  "usercred", dataProviderClass =DataProviderDemo.class)


	// To use data provider within the class 

	@Test (priority = 2, dataProvider="logInCredentials")
	public void giveLogInINputs(String email, String passw, int No ) {


		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(passw);
		driver.findElement(By.name("login")).click();
		System.out.println("Log in of user "+  No  +" user is done");

	}



	@DataProvider(name ="logInCredentials")
	public Object [][] credentials(){
		Object[] [] values = null;
		values = new Object[] [] {
			{"shweta", "shwiririit",1},
			{"skswer@gmail.com", "4567", 2},
			{"skswer@gmail.com", "8912", 3}
		};
		return values;


	}
}
