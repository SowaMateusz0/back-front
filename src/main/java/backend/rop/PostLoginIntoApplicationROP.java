package backend.rop;

import backend.configRequest.RequestConfiguration;
import backend.pojo.postLoginIntoApplication.LoginRequestPayload;
import backend.pojo.postLoginIntoApplication.LoginResponsePayload;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class PostLoginIntoApplicationROP extends BaseRequestObjectPattern<PostLoginIntoApplicationROP, LoginResponsePayload>{

    private LoginRequestPayload loginPayload;

    @Override
    protected Type responsePayload() {
        return LoginResponsePayload.class;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    public PostLoginIntoApplicationROP sendRequestPayload() {
        response = given()
                .spec(RequestConfiguration.getConfigRequest())
                .body(loginPayload)
                .when()
                .post("auth/login");
        return this;
    }

    public PostLoginIntoApplicationROP setLoginPayload(LoginRequestPayload loginPayload){
        this.loginPayload = loginPayload;
        return this;
    }
}
