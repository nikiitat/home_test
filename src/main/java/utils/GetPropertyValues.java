package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nikitatertytskyi on 11.12.17.
 */
public class GetPropertyValues {
    private final Properties prop = new Properties();
    private InputStream inputStream;

    public GetPropertyValues() throws IOException{
        try {
            inputStream = getClass().getResourceAsStream("/config/config.properties");
            if (inputStream != null){
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getChromeDriverPath(){
        return prop.getProperty("chromedriverpath");
    }

    public String getFireFoxDriverPath(){
        return prop.getProperty("firefoxdriverpath");
    }
}
