package utilities;

import java.util.Properties;

import utilities.ReadPropertiesFile;

public class AccessProperties {

static Properties prop=ReadPropertiesFile.readPropertiesFile();
    
	public static  String getUrl()
	{
			return prop.getProperty("url");
	}
	public static String getBrowser()
	{
			return prop.getProperty("browser");
	}
} 