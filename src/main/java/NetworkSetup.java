import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.devtools.v93.network.model.Request;
import org.openqa.selenium.devtools.v93.network.model.Response;


import java.util.Optional;

public class NetworkSetup {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iqra's User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();  // Initialize the chrome driver
        DevTools devTools = driver.getDevTools();  // Initialize the dev tool object to interact with chrome dev tool
        devTools.createSession();  //Start session to communicate between browser and dev tool

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), Request ->
        {
            Request req=Request.getRequest();
            System.out.println(req.getHeaders() + ""+req.getUrl());

        });
        devTools.addListener(Network.responseReceived(), Response ->
        {
            org.openqa.selenium.devtools.v93.network.model.Response rs=Response.getResponse();
          //  System.out.println("response"+rs.getUrl());
            System.out.println("response"+rs.getStatus());

        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[text()= ' Virtual Library ']")).click();

    }


    }
