package LambdaDemo;
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LaunchBrowser {
	
	@Test
	
	public void myTest() {
		
System.setProperty("webdriver.chrome.driver", "./Drivers/ChromeDriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://jamesroberts-trial.interactgo.com/login?returnUrl=%2F");
WebElement usernameinput = driver.findElement(By.id("Username"));
usernameinput.sendKeys("qa-test-6");
WebElement passwordinput = driver.findElement(By.id("Password"));
passwordinput.sendKeys("qt6");

WebElement loginbutton = driver.findElement(By.id("loginbtn"));
loginbutton.click();

String expectedurl ="https://jamesroberts-trial.interactgo.com/#home";

String actualurl =driver.getCurrentUrl();

Assert.assertEquals(actualurl,expectedurl);

String expectedmessage ="Global News";
String pagesource = driver.getPageSource();
Assert.assertTrue(pagesource.contains(expectedmessage));

WebElement profilelink = driver.findElement(By.className("status-user"));
profilelink.click();

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// identify element
WebElement addblog = driver.findElement(By.linkText("Add Blog Post"));
// href value from getAttribute()
String v = addblog.getAttribute("href");
addblog.click();

//WebDriverWait wait = new WebDriverWait(driver, 10);
//WebElement imageupload = wait.until(
  //      ExpectedConditions.visibilityOfElementLocated(By.id("blog-post-uploader-button")));

WebElement imageupload = driver.findElement(By.id("blog-post-uploader-button"));
imageupload.click();


File uploadFile = new File("src/test/resources/test.jpg");
WebElement imageInput = driver.findElement(By.name("qqfile"));
imageInput.sendKeys("C:\\Users\\saita\\workspace\\DemoOne\\src\\test\\resources\\test.jpg");



//driver.quit();

}

}
