package com.calcados.modelo;

import com.calcados.enumerations.FaixaEtaria;

import java.util.Objects;

public class Produto {
    private String codigo;
    private String marca;
    private double preco;
    private String cor;
    private String descricao;
    private FaixaEtaria faixaEtaria;  // Usa o tipo criado no enum para garantir integridade

    public Produto() {
    }

    public Produto(String codigo, String marca, double preco, String cor, String descricao, FaixaEtaria faixaEtaria){
        this.codigo = codigo;
        this.marca = marca;
        this.preco = preco;
        this.cor = cor;
        this.descricao = descricao;
        this.faixaEtaria = faixaEtaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }


    @Override
    public boolean equals(Object obj) {
        Produto produto = (Produto) obj;
        return Objects.equals(this.codigo, produto.getCodigo());
    }
}
