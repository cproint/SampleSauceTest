import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;


public class SauceConnectWithJenkinPlugIn {

    static RemoteWebDriver driver;


    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

    static String URL;



    public static void main(final String[] args) throws InterruptedException, MalformedURLException {

        RemoteWebDriver driver;

        URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com/wd/hub";

        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("version", "latest");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("name", "groupmdemo");


        driver = new RemoteWebDriver(new java.net.URL(URL), caps);
        driver.get("https://www.groupm.com/");

        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (driver.getTitle().equalsIgnoreCase("Home | GroupM") ? "passed" : "failed"));


        driver.quit();
    }
}

