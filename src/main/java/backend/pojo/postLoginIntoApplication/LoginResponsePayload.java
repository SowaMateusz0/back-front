package backend.pojo.postLoginIntoApplication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponsePayload {
    public String token;
    public String userId;
    public String message;
}
