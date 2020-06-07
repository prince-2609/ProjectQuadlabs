package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaRepositery {

	public void init(Properties obj) throws IOException {
		obj = new Properties();
		String propsDir = System.getProperty("user.dir") + "\\repository";
		String[] files = {"LoginObject","Flight","Transfer","Travelmall"};
		String propsFileSuffix = ".properties";
		
		for (String file : files) {
			file = propsDir + "\\" + file + propsFileSuffix;
			FileInputStream inputStream =  new FileInputStream(file);
			obj.load(inputStream);
		}
	}
}
