package backend.pojo.postLoginIntoApplication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestPayload {
    public String userEmail;
    public String userPassword;
}
