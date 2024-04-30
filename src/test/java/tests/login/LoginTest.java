package tests.login;

import backend.pojo.postLoginIntoApplication.LoginRequestPayload;
import backend.rop.PostLoginIntoApplicationROP;
import data.data1.User;
import data.data1.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static utilities.ReadDataFromFile.readDataFromXmlFile;


public class LoginTest extends BaseClass {

    private Logger log;
    private LoginRequestPayload loginRequestPayload;

    
    @Test
    public void validateTitle() throws IOException, JAXBException {

        log = LogManager.getLogger(this.getClass().getName());
        String filePath = "\\src\\main\\resources\\testData\\data1.xml";

        UserData userData = (UserData) readDataFromXmlFile(filePath,UserData.class);
        List<User> users = userData.getUsers();
        loginRequestPayload = new LoginRequestPayload();
        loginRequestPayload.setUserEmail(users.get(0).getEmail());
        loginRequestPayload.setUserPassword(users.get(0).getPassword());

        System.out.println(loginRequestPayload);
        new PostLoginIntoApplicationROP()
                .setLoginPayload(loginRequestPayload)
                .sendRequestPayload()
                .assertRequestSuccess();

        Assert.assertEquals(driver.getTitle(),"Let's Shop");
        log.info("Validate title");
    }
}
