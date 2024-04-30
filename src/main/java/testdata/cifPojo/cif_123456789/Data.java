package testdata.cifPojo.cif_123456789;


import javax.xml.bind.annotation.XmlElement;

public class Data {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}
