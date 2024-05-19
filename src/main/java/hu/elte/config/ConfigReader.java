package hu.elte.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties = new Properties();

    public ConfigReader() {
        try (var stream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String[] getArray(String key) {
        return properties.getProperty(key).split(";");
    }
}
