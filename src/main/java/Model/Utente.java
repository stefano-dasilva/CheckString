package Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

@Entity

@Table(name= "Utente")
public class Utente implements Bean{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "username")
    private String username;

    @Column (name = "nazione")
    private String nazione;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private Date dataNascita;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @Column(name = "record_bandiere")
    private Integer recordBandiere;

    @Column(name = "record_capitali")
    private Integer recordCapitali;

   // @NotNull
    @Column(name = "record_popolazioni")
    private Integer recordPopolazioni;


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nazione='" + nazione + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", password='" + password + '\'' +
                ", img=" + Arrays.toString(img) +
                ", recordBandiere=" + recordBandiere +
                ", recordCapitali=" + recordCapitali +
                ", recordPopolazioni=" + recordPopolazioni +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public byte[] getImmagine() {
        return img;
    }

    public void setImmagine(byte[] immagine) {
        this.img = immagine;
    }

    public void setRecordBandiere(Integer recordBandiere) {
        this.recordBandiere = recordBandiere;
    }

    public void setRecordCapitali(Integer recordCapitali) {
        this.recordCapitali = recordCapitali;
    }

    public void setRecordPopolazioni(Integer recordPopolazioni) {
        this.recordPopolazioni = recordPopolazioni;
    }

    public Integer getRecordBandiere() {
        return recordBandiere;
    }

    public Integer getRecordCapitali() {
        return recordCapitali;
    }

    public Integer getRecordPopolazioni() {
        return recordPopolazioni;
    }
}
