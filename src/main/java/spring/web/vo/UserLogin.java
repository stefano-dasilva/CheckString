package spring.web.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserLogin {

    @NotNull
    private String username;
    private String passoword;
    @NotNull
    @Pattern(regexp = "^(?=.*[@#$%^&+=!]).{6,}$", message = "non rispetta il formato")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }
}
