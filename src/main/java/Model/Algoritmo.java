package Model;

import javax.persistence.*;

@Entity
@Table (name = "algoritmo")

public class Algoritmo implements Bean  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "nome")
    private String nome;

    @Column(name = "successo")
    private double successo;

    @Column(name = "media_tempo")
    private double mediaTempo;

    @Column(name = "corr_trovate")
    private int corrispondenzeTrovate;

    @Column(name = "corr_approvate")
    private int corrispondeApprovate;


    public Algoritmo(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSuccesso(double successo) {
        this.successo = successo;
    }

    public double getSuccesso() {
        return successo;
    }

    public double getMediaTempo() {
        return mediaTempo;
    }

    public void setMediaTempo(double mediaTempo) {
        this.mediaTempo = mediaTempo;
    }

    public int getCorrispondenzeTrovate() {
        return corrispondenzeTrovate;
    }

    public int getCorrispondeApprovate() {
        return corrispondeApprovate;
    }

    public void setCorrispondeApprovate(int corrispondeApprovate) {
        this.corrispondeApprovate = corrispondeApprovate;
    }

    public void setCorrispondenzeTrovate(int corrispondenzeTrovate) {
        this.corrispondenzeTrovate = corrispondenzeTrovate;
    }
}
