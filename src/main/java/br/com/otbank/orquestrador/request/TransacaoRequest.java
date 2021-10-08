package br.com.otbank.orquestrador.request;

import java.math.BigDecimal;

public class TransacaoRequest {

    private String numeroConta;

    private String idCliente;

    private BigDecimal valor;
    private TipoTransacao tipoTransacao;

    public TransacaoRequest() {
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public NovaTransacaoExtratoRequest toExtratoRequest(){
        return new NovaTransacaoExtratoRequest(this);
    }
}
