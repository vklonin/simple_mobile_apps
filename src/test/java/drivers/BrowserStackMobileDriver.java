package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {

    private static AndroidTestsConfig.DeviceConfig config = ConfigFactory
                .create(AndroidTestsConfig.DeviceConfig.class, System.getProperties());


//    Configuration.browser = config.browserName();
//    Configuration.browserVersion = config.browserVersion();
//
//        if(System.getenv("type").equals("remote")) {
//        Configuration.remote = config.webDriverUrl();
//    }



    private URL getBrowserstackUrl() {

        System.out.println(config.webDriverUrl());

        try {
            return new URL(config.webDriverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.login());
        desiredCapabilities.setCapability("browserstack.key", config.password());


        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test_of_mine");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}
