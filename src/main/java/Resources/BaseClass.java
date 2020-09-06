package Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver Driver;

    public WebDriver InitializeBrowser() throws IOException {
        Properties GlobalProperties = new Properties();
        FileInputStream GlobalFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalProperties.properties");
        GlobalProperties.load(GlobalFile);
        String BrowserName = GlobalProperties.getProperty("browser");
        if (BrowserName.equals("chrome")) {
            DesiredCapabilities DCap = DesiredCapabilities.chrome();
            DCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.merge(DCap);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\chromedriver.exe");
            Driver = new ChromeDriver(options);
        } else if (BrowserName.equals("firefox")) {
            DesiredCapabilities DCap = DesiredCapabilities.firefox();
            DCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.merge(DCap);
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\geckodriver.exe");
            Driver = new FirefoxDriver(options);
        } else if (BrowserName.equals("Edge")) {
            DesiredCapabilities DCap = DesiredCapabilities.edge();
            DCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            EdgeOptions options = new EdgeOptions();
            options.merge(DCap);
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\msedgedriver.exe");
            Driver = new EdgeDriver(options);
        }
        Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.manage().window().maximize();
        return Driver;
    }
    public WebDriver getURL() throws IOException {
        Properties GlobalProperties = new Properties();
        FileInputStream GlobalFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalProperties.properties");
        GlobalProperties.load(GlobalFile);
        String URL = GlobalProperties.getProperty("url");
        Driver.get(URL);
        return Driver;
    }
    public String getScreenshot(String MethodName, WebDriver FailedDriver) throws IOException {
        TakesScreenshot ScrShot = (TakesScreenshot) FailedDriver;
        File Source = ScrShot.getScreenshotAs(OutputType.FILE);
        String DesFile = System.getProperty("user.dir")+"\\reports\\Screenshots\\"+MethodName+".jpg";
        FileUtils.copyFile(Source,new File(DesFile));
        return DesFile;
    }

}
