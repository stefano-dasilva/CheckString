package spring.web.vo.Filter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ClassificaFilter {




    @Positive(message = "min < 0")
    private Integer minimo;
    @Positive(message = "max < 0")
    private Integer massimo;
    private String categoriaGioco;
    private String nazione;


    public Integer getMinimo() {
        return minimo;
    }

    public Integer getMassimo() {
        return massimo;
    }

    public void setMassimo(Integer massimo) {
        this.massimo = massimo;
    }

    public String getCategoriaGioco() {
        return categoriaGioco;
    }

    public void setCategoriaGioco(String categoriaGioco) {
        this.categoriaGioco = categoriaGioco;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }
}
