import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iqra's User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.name("name"));

        ///////////////// below of /////////////

      System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());
        System.out.println((driver.findElements(with(By.tagName("label")).below(name))).size());

        //////////// Right of /////////////
        Thread.sleep(5000);
        WebElement radio=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
        Thread.sleep(5000);

////////////////left of ////////////////////
        WebElement icecream=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(icecream)).click();

        Thread.sleep(5000);

////////////////////////below //////////////////////
        WebElement password=driver.findElement(By.xpath("//input[@class='btn btn-success']"));

      driver.findElement(with(By.tagName("input")).below(password)).sendKeys("02/02/1994");

/////////get the screenshot /////////////
      WebElement screenshot=driver.findElement(By.name("name"));
      File file =screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));
        Thread.sleep(5000);

//////////// Widht and Height ///////////////

        WebElement bday=driver.findElement(By.name("bday"));
        System.out.println("Height \n"+bday.getRect().getHeight());
        System.out.println("width \n"+bday.getRect().getWidth());

  ////// Multiple windows ///////////////
        driver.switchTo().newWindow(WindowType.TAB);
      Set<String> handle= driver.getWindowHandles();
      Iterator<String> it=handle.iterator();
      String parentWindow=it.next();
      String childWindow=it.next();
      driver.switchTo().window(childWindow);
      driver.get("https://google.com/");

      driver.quit();

      

    }


}
