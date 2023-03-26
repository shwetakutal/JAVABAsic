import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ActionsMouseHover {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		ChromeDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Launch url
		driver.get("https://www.globalsqa.com/demo-site/");
		System.out.println(driver.getTitle());

		//Instantiate Action Class 
		
		Actions actions = new Actions(driver);
		
		//Retrieve WebElement 'Testers hub' to perform mouse hover 
		WebElement menuOption = driver.findElement(By.xpath("//a[@class='no_border'][text()='Tester’s Hub']"));
		//Mouse hover menuOption 'Tester’s Hub'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'Tester’s Hub' from Menu");

		//Now Select 'AngularJS Protractor Practice Site' from sub menu which has got displayed on mouse hover of 'Tester’s Hub'
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.linkText("AngularJS Protractor Practice Site")));
		
		
		actions.moveToElement(driver.findElement(By.linkText("AngularJS Protractor Practice Site"))).perform();
		
		//WebElement subMenuOption =
//		 driver.findElement(By.xpath("//a[@href='https://www.globalsqa.com/angularjs-protractor-practice-site/'][text()='AngularJS Protractor Practice Site']")); 
		//Mouse hover menuOption 'AngularJS Protractor Practice Site'
//		actions.moveToElement(subMenuOption).perform();
		 
		System.out.println("Done Mouse hover on 'AngularJS Protractor Practice Site' from Menu");

		//Now , finally, it displays the desired menu list from which required option needs to be selected
		//Now Select 'Scrollable' from sub menu which has got displayed on mouse hover of 'AngularJS Protractor Practice Site'
		
		WebElement selectMenuOption = driver.findElement(By.xpath("//*[@id=\"menu-item-2841\"]/a/span"));
		selectMenuOption.click();
		System.out.println("Scrollable");

		// Close the main window 
		driver.close();


	}

}
