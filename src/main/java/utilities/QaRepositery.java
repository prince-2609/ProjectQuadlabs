package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaRepositery {


	public Properties init() throws IOException {
		Properties	obj = new Properties();
		String propsDir = System.getProperty("user.dir") + "\\repository";
		String[] files = {"LoginObject","Flight","Flight1","Transfer","Travelmall","Sbt_flight","Hotel","Corporate_Management","JOLO_SBT","CorporateSetting"};
		String propsFileSuffix = ".properties";
		
		for (String file : files) {
			file = propsDir + "\\" + file + propsFileSuffix;
			FileInputStream inputStream =  new FileInputStream(file);
			obj.load(inputStream);
		}
		return obj;
	}
	// set default respository file
	
}
