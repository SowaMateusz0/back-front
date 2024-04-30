package utilities;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


@UtilityClass
public class CaptureScreenshot {

    public static String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = "./screens/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationPath));
        return destinationPath;
    }
}
