package Model;
import Dao.Interface.Bean;

import javax.persistence.*;


@Entity

@Table (name = "corrispondenza")
public class Corrispondenza  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;

    @Column (name = "num_ricerche")
    private Integer numRicerche;


    @Column (name =  "input")
    private String input;

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
}
