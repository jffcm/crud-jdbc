package model;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Compras {
    
    private long id;
    private BigDecimal valor;
    private String observacoes;
    private LocalDate data;
    private boolean recebida;

    public Compras(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean getRecebida(){
        return recebida;
    }

    public void setRecebida(boolean recebida) {
        this.recebida = recebida;
    }

    @Override
    public String toString(){
        String registros = "Id: " + id;
        registros += "\nValor: " + valor;
        registros += "\nObservações: " + observacoes;
        registros += "\nData: " + data;
        registros += "\nRecebida: " + recebida;
        return registros;
        
    }

}
