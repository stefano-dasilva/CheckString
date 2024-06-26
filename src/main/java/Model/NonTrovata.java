package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table (name = "nontrovata")
public class NonTrovata implements Bean  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "input")
    private String input;


    @Column(name = "num_ricerche",  columnDefinition = " default '0'")

    private Integer numRicerche;

    public NonTrovata() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getNumRicerche() {
        return numRicerche;
    }

    public void setNumRicerche(Integer numRicerche) {
        this.numRicerche = numRicerche;
    }
}
