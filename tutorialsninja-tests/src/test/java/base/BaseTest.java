// base/BaseTest.java
package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {

    
    // Each thread now gets its own WebDriver instance — no cross-thread interference.
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    // Each thread loads its own config safely.
    private static final ThreadLocal<Properties> propThread = new ThreadLocal<>();

    // These getters are used by test classes and TestListener
    public WebDriver driver() {
        return driverThread.get();
    }

    public Properties prop() {
        return propThread.get();
    }

    
    // so existing test code like 'new HomePage(driver)' still compiles
    public WebDriver driver;

    protected Properties prop;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws IOException {
        Properties p = new Properties();
        String configPath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "config.properties";
        FileInputStream file = new FileInputStream(configPath);
        p.load(file);
        file.close();
        propThread.set(p);
        prop = p; 

        WebDriver d;
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless"); // uncomment for CI
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                d = new ChromeDriver(options);
                break;
            case "edge":
                d = new EdgeDriver();
                break;
            case "firefox":
                d = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        d.manage().deleteAllCookies();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        d.get(p.getProperty("url"));

        
        driverThread.set(d);
        driver = d;
    }

    public String captureScreenshot(String testName) {
        File folder = new File(System.getProperty("user.dir") + "/test-output/screenshots/");
        if (!folder.exists()) folder.mkdirs();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = folder.getAbsolutePath() + "/" + testName + "_" + timestamp + ".png";
        File src = ((TakesScreenshot) driverThread.get()).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    @AfterMethod
    public void tearDown() {
        // to prevent memory leaks across parallel threads
        WebDriver d = driverThread.get();
        if (d != null) {
            d.quit();
            driverThread.remove();
        }
        propThread.remove();
    }
}