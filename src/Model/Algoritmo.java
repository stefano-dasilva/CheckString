package Model;

import Dao.Interface.Bean;

import javax.persistence.*;

@Entity
@Table (name = "algoritmo")

public class Algoritmo  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "nome")
    private String nome;

    @Column(name = "successo")
    private Integer successo;


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

    public void setSuccesso(Integer successo) {
        this.successo = successo;
    }

    public Integer getSuccesso() {
        return successo;
    }

}
