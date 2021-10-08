package br.com.otbank.orquestrador.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NovaTransacaoExtratoRequest {
    private String numeroConta;

    private String idCliente;

    private BigDecimal valor;
    private TipoTransacao tipoTransacao;

    private LocalDate dataTransacao = LocalDate.now();

    public NovaTransacaoExtratoRequest(TransacaoRequest transacaoRequest) {
        this.numeroConta = transacaoRequest.getNumeroConta();
        this.idCliente = transacaoRequest.getIdCliente();
        this.valor = transacaoRequest.getValor();
        this.tipoTransacao = transacaoRequest.getTipoTransacao();
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

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
