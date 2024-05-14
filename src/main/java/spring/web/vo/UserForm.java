package spring.web.vo;

import com.sun.istack.NotNull;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {


    @NotNull
    @Size(min=3, max=20, message="password dev'essere tra 3 e 20 caratteri ")
    private String username;
    @NotNull
    @Size(min=6, max=20, message="password dev'essere tra 6 e 20 caratteri ")
    @Pattern(regexp = "^(?=.*[@#$%^&+=!]).{6,}$", message = "non rispetta il formato")
    private String password;
    private String dataNascita;
    @NotNull
    @Size(min=2, message="nome troppo corto ")
    private String nome;
    @NotNull
    @Size(min=2, message="cognome troppo corto ")
    private String cognome;
    @NotNull
    @Size(min=2, message="Nazione troppo corta ")
    private String nazione;



    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;

    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNazione( String nazione) {
        this.nazione = nazione;
    }

    public String getNazione() {
        return nazione;
    }
}
