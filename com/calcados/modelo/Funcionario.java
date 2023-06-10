package com.calcados.modelo;

public abstract class Funcionario {
    private String nomeCompleto;
    private String CPF;
    private String telefone;
    private String endereco;
    private double salario;
    private String funcao;


    public Funcionario(String nomeCompleto, String CPF, String telefone, String endereco, double salario, String funcao) {
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public abstract double calculaSalario(int mes, int ano);
}
