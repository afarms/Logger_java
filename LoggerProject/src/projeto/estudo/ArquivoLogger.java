package projeto.estudo;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArquivoLogger {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("Mylogger");
		
		FileHandler fileHandler;
		String localPath = System.getProperty("user.dir");
		
		try {
			fileHandler = new FileHandler(localPath+"\\src\\resources\\Mylogger.txt");
			logger.addHandler(fileHandler);
			
			SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.info("Log to test");
			
		} catch (SecurityException e) {
			logger.info("Exception:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("IO Exception:" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Hi In the main class");
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}
}
