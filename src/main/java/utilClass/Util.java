package utilClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Util {
	
	public static String getScreenshot(WebDriver driver, String methodName) throws IOException {
		
		String path = methodName + ".png";
		
		TakesScreenshot k = (TakesScreenshot)driver;
		File source = k.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(source, destination);
		
		return path;
	}

}
