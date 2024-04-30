package utilities.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {

    private int count = 0;
    private static final int NUMBER_OF_RETRIES = 1;
    private final Logger logger = LogManager.getLogger(IRetry.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < NUMBER_OF_RETRIES) {
                count++;
                logger.info("Retrying test method " + iTestResult.getName());
                return true;
            }
        }
        else {
            logger.info("Test method" + iTestResult.getName() + "will be not retried");
        }
        return false;
    }
}
