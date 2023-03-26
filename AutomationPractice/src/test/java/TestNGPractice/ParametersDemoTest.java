package TestNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemoTest {

	WebDriver driver;
	@Parameters("browser")
	@Test
	public void setupTestTest(String browser ) {
		//Print console that code is in @BeforeMethod!
		System.out.println("@BeforeMethod has started.");
		//Browser Selection based on browser parameter
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("You set a wrong browser parameter!");
		}
	}
	@Parameters({"URL", "Comment"})
	@Test (priority =1)
	public void LaunchWebsiteTest(String URL, String Comment) {
		driver.get(URL);
		assert URL.equals("https://www.swtestacademy.com/testng-tutorial/");
		System.out.println(Comment);

	}
}
