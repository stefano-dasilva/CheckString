package Filter;

public class ClassificaFilter {



    private Integer minimo;
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
