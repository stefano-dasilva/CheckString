package spring.web.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserLogin {

    @NotNull
    private String username;

    @Size(min=6, max=20, message="password dev'essere tra 6 e 20 caratteri ")
    @Pattern(regexp = "^(?=.*[@#$%^&+=!]).{6,}$", message = "non rispetta il formato")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
