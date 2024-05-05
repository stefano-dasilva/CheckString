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

    @Column(name = "percentuale_approvazione")
    private double percentualeApprovazione;


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

    public double getPercentualeApprovazione() {
        return percentualeApprovazione;
    }

    public void setPercentualeApprovazione(double percentualeApprovazione) {
        this.percentualeApprovazione = percentualeApprovazione;
    }
}
