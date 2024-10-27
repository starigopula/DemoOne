package LambdaDemo;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LaunchBrowser {

    @Test

    public void myTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://jamesroberts-trial.interactgo.com/login?returnUrl=%2F");
        WebElement usernameinput = driver.findElement(By.id("Username"));
        usernameinput.sendKeys("qa-test-6");
        WebElement passwordinput = driver.findElement(By.id("Password"));
        passwordinput.sendKeys("qt6");

        WebElement loginbutton = driver.findElement(By.id("loginbtn"));
        loginbutton.click();

        String expectedurl = "https://jamesroberts-trial.interactgo.com/#home";

        String actualurl = driver.getCurrentUrl();

        Assert.assertEquals(actualurl, expectedurl);

        String expectedmessage = "Global News";
        String pagesource = driver.getPageSource();
        Assert.assertTrue(pagesource.contains(expectedmessage));

        WebElement profilelink = driver.findElement(By.className("status-user"));
        profilelink.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement addblog = driver.findElement(By.linkText("Add Blog Post"));
        String v = addblog.getAttribute("href");
        addblog.click();


        File uploadFile = new File("src/test/resources/Test.jpg");
        WebElement imageInput = driver.findElement(By.name("qqfile"));
        imageInput.sendKeys(uploadFile.getAbsolutePath());


        WebElement blogTitle = driver.findElement(By.cssSelector("[aria-label='Post title']"));
        blogTitle.sendKeys("My salad blog");

        WebElement blogSummary = driver.findElement(By.cssSelector("[aria-label='Post Summary']"));
        blogSummary.sendKeys("Here, you'll learn how to prepare a vibrant, nutritious chicken chopped salad, perfect for busy days or when you crave something light yet filling.");

        WebElement blogContent = driver.findElement(By.id("blogPostBodyContent"));
        Actions actions = new Actions(driver);
        actions.moveToElement(blogContent);
        blogContent.sendKeys("For the last year, I have been making an effort to post about the easy to make food that I eat all the time. This “recipe” fits that brief, possibly more than any other on this blog.  I eat this salad a few times a week, pretty much year round, for years and years now. I’ve photographed it here on a nice plate, but in fact I never eat this at home. This is what I pack for lunch almost much everyday that I leave my house for work.");

        WebElement continueButton = driver.findElement(By.cssSelector("[aria-label='Continue']"));
        continueButton.click();

        WebElement labelSwitch = wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath("//label[contains(@class, 'switch')]")).get(1)));
        labelSwitch.click();

        WebElement saveButton = driver.findElement(By.linkText("Save"));
        saveButton.click();

//driver.quit();

    }

}
