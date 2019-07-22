package com.self.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	
	public ConfigReader() {
		try {
			File file = new File("./config/config.properties");
			FileInputStream src = new FileInputStream(file);
			prop =new Properties();
			prop.load(src);
		} catch (Exception e) {
			System.out.println("Config File is not loaded properly : "+ e.getMessage());
		}
	}

	public String readDataFromConfig(String key) {
		return prop.getProperty(key);
	}
}
