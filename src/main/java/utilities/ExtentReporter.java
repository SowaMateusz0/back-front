package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;


@UtilityClass
public class ExtentReporter {

    static ExtentReports extent;

    public static ExtentReports getReportObject(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
        String currentData = simpleDateFormat.format(new Date());

        String path = System.getProperty("user.dir")+"\\reports\\report- " + currentData + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation tests results");
        reporter.config().setDocumentTitle("Test results");
        reporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.getStats();

        return extent;
    }




}
