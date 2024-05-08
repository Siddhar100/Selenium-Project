import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
     
	WebDriver driver;
	@BeforeTest
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\\\\\\\\\web-driver\\\\\\\\\\\\\\\\chromedriver-win64\\\\\\\\\\\\\\\\chromedriver-win64\\\\\\\\\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
	}
	@Test
	public void testCase1() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void testCase2() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement desktop = driver.findElement(By.linkText("Desktops"));
		action.moveToElement(desktop).build().perform();
		Thread.sleep(2000);
		WebElement showAllDesktop = driver.findElement(By.linkText("Show AllDesktops"));
		showAllDesktop.click();
		Thread.sleep(4000);
	}
	@Test
	public void testCase3() throws InterruptedException {
		driver.findElement(By.linkText("HP LP3065")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		Thread.sleep(4000);
	}
	@Test
	public void testCase4() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='radio'][@value='guest']")).click();
		driver.findElement(By.xpath("//input[@id='button-account']")).click();
		Thread.sleep(4000);
		
	}
	@Test
	public void testCase5() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Siddhartha");
		driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Chakaraborty");
		driver.findElement(By.xpath("//input[@id='input-payment-email']")).sendKeys("sid@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-payment-telephone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("Kolaghat");
		driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("Kolaghat");
		driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("721212");
		Select country = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']")));
		country.selectByIndex(3);
		Thread.sleep(3000);
		Select objSelect =new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
		objSelect.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
		Thread.sleep(4000);
	}
	@Test
	public void testCase6() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
		Thread.sleep(4000);
	}
	@Test
	public void testCase7() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
		Thread.sleep(4000);
	}
	@Test
	public void testCase8() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
		Thread.sleep(4000);	
	}
	@Test
	public void testCase9() {
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}
	@AfterTest
	public void destroy() {
		//driver.quit();
	}
	
}
