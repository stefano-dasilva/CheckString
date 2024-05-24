package spring.web.vo;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class SalvaRegister {

    @NotNull
    @Size(min=3, max=20, message="username dev'essere tra 3 e 20 caratteri ")
    private String username;


    @NotNull
    @Size(min=2, message="nome troppo corto ")
    private String nome;
    @NotNull
    @Size(min=2, message="cognome troppo corto ")
    private String cognome;
    @NotNull
    @Size(min=2, message="Nazione troppo corta ")
    private String nazione;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascita;




    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }



    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
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

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;

    }

    public Date getDataNascita() {
        return dataNascita;
    }




}


