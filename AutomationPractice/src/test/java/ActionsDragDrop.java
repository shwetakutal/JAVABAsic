import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ActionsDragDrop {
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		ChromeDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		draggable();
		//		dropable();
		Thread.sleep(3000);

		driver.quit();
	}

	public static void draggable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/draggable");
		System.out.println(driver.getTitle());
		WebElement source = driver.findElement(By.id("header"));
		Actions A = new Actions(driver);
		//		Point location = source.getLocation();
		int x = source.getLocation().getX();
		int y = source.getLocation().getY();
		// using only element to drag anywhere in the given page
		A.dragAndDropBy(source, x+500, y+200).build().perform();

	}
	public static void dropable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/dropable");
		System.out.println(driver.getTitle());
		WebElement source = driver.findElement(By.id("text"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions A = new Actions(driver);
		// using dragAnddrop() method to use source and destination location for the element
		A.dragAndDrop(source, destination).perform();
	}
}


