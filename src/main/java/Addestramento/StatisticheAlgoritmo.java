package Addestramento;

public class StatisticheAlgoritmo {


    private int casiSuccesso;
    private double tempoSuccesso;

    public StatisticheAlgoritmo(){
        this.casiSuccesso = 0;
        this.tempoSuccesso = 0.0;
    }

    public int getCasiSuccesso() {
        return casiSuccesso;
    }

    public void setCasiSuccesso(int casiSuccesso) {
        this.casiSuccesso = casiSuccesso;
    }

    public double getTempoSuccesso() {
        return tempoSuccesso;
    }

    public void setTempoSuccesso(double tempoSuccesso) {
        this.tempoSuccesso = tempoSuccesso;
    }
}
