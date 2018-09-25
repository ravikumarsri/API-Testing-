package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseApi {
	public Properties pro;
	
	public  BaseApi() {
		
		
		 pro = new Properties();
		
		try {
			FileInputStream file = new FileInputStream ("C:\\Users\\dssri\\eclipse-workspace\\Resttesting\\src\\main\\java\\Config\\Config.properties");
			pro.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
