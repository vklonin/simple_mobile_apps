package drivers;

import org.aeonbits.owner.Config;

public class AndroidTestsConfig {

    @Config.Sources({
            "classpath:config/credentials.properties"
    })
    interface DeviceConfig extends Config {
        @Key("login")
        String login();

        @Key("password")
        String password();

        @Key("webDriverUrl")
        String webDriverUrl();
    }
}

