package Model;

import javax.persistence.*;


@Entity

@Table (name = "corrispondenza")
public class Corrispondenza implements Bean  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "standard_value", referencedColumnName = "value")
    private Standard standard;

    @Column (name = "num_ricerche")
    private Integer numRicerche;

    @Column (name =  "input")
    private String input;

    @Column (name =  "algoritmo_usato")
    private String algoritmo_usato;

    @Column (name =  "approvata")
    private boolean approvata;

    public Corrispondenza(Standard standard){
        this.standard = standard;
    }

    public Corrispondenza(){

    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNumRicerche(Integer numRicerche) {
        this.numRicerche = numRicerche;
    }

    public Integer getNumRicerche() {
        return numRicerche;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setAlgoritmo_usato(String algoritmo_usato) {this.algoritmo_usato = algoritmo_usato;}

    public String getAlgoritmo_usato() {return algoritmo_usato; }

    public void setApprovata(boolean approvata) {this.approvata = approvata;}

    public boolean getApprovata() {return approvata;}
}
