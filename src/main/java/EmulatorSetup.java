import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.browser.Browser;
import org.openqa.selenium.devtools.v93.emulation.Emulation;
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.devtools.v93.network.model.Cookie;
import org.openqa.selenium.devtools.v93.storage.Storage;

import java.util.List;
import java.util.Optional;

public class EmulatorSetup {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Iqra's User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();  // Initialize the chrome driver
        DevTools devTools=driver.getDevTools();  // Initialize the dev tool object to interact with chrome dev tool
        devTools.createSession();  //Start session to communicate between browser and dev tool
        devTools.send(Emulation.setDeviceMetricsOverride(375,667,50,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        // set the browser to the device like mobile device with width and height and zoom value.


        driver.manage().window().maximize();
        driver.get("https://sso.teachable.com/secure/9521/identity/login");

        driver.findElement(By.name("email")).sendKeys("iqrabibi25@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("abcd");
        driver.findElement(By.name("commit")).click();
       System.out.println("Website version"+devTools.send(Browser.getVersion()));


        Thread.sleep(5000);
      // devTools.close();
        driver.close();



    }
}
