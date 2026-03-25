package br.com.ecommerce.model;

import java.time.LocalDate;

public class Promocao {

    private String codigoCupom;
    private String tipoDesconto;
    private double valorDesconto;
    private LocalDate dataValidade;
    private boolean ativo;
    private double valorMinimo;

    public Promocao(String codigoCupom, String tipoDesconto, double valorDesconto,
                    LocalDate dataValidade, boolean ativo, double valorMinimo) {
        this.codigoCupom = codigoCupom;
        this.tipoDesconto = tipoDesconto;
        this.valorDesconto = valorDesconto;
        this.dataValidade = dataValidade;
        this.ativo = ativo;
        this.valorMinimo = valorMinimo;
    }

    public String getCodigoCupom() { return codigoCupom; }
    public String getTipoDesconto() { return tipoDesconto; }
    public double getValorDesconto() { return valorDesconto; }
    public LocalDate getDataValidade() { return dataValidade; }
    public boolean isAtivo() { return ativo; }
    public double getValorMinimo() { return valorMinimo; }
}