import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeoLocation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iqra's User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();  // Initialize the chrome driver
        DevTools devTools = driver.getDevTools();  // Initialize the dev tool object to interact with chrome dev tool
        devTools.createSession();  //Start session to communicate between browser and dev tool

        Map<String, Object> device = new HashMap<>();
        device.put("latitude",41.881832);  //34.052235
        device.put("longitude",-87.623177);  // -118.246838    los angels
        device.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", device);



//       Optional<Number> num= Optional.of(40);
//        Optional<Number> num2=Optional.of(3);
//        devTools.send(Emulation.setGeolocationOverride(Optional.of(21.7679), Optional.of(21.7679), Optional.of(0d)));
//
        driver.get("https://oldnavy.gap.com/stores");
//        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
//        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
//        System.out.println(driver.getTitle());
//
//        Thread.sleep(5000);
//        driver.close();

    }
}
