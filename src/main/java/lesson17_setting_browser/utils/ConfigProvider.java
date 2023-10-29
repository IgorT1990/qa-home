package lesson17_setting_browser.utils;
import java.util.Properties;
import java.io.IOException;

public final class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();
    public static final String BROWSER = prop.getProperty("browser");
    public static final String BASE_URL = prop.getProperty("base.url");

    private ConfigProvider() {

    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties: " + CONFIG_PATH);
        }
        return properties;
    }


}