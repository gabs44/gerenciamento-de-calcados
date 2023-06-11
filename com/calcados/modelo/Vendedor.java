package com.calcados.modelo;

import com.calcados.interfaces.Comissionado;

import java.util.ArrayList;

// Implementação de herança
public class Vendedor extends Funcionario implements Comissionado {
    private ArrayList<Venda> vendas = new ArrayList<Venda>();
    private double comissao;

    public Vendedor() {
    }

    public Vendedor(String nomeCompleto, String CPF, String telefone, String endereco,
                    double salario, String funcao, double comissao) {
        super(nomeCompleto, CPF, telefone, endereco, salario, funcao);
        this.comissao = comissao;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario(int mes, int ano){
        double valorComissao = calculaComissao(mes, ano);
        return valorComissao + getSalario();
    }

    public double calculaComissao(int mes, int ano){
        double total =0;
        for (Venda venda: vendas) {
            if (venda.getData().getYear() == ano && venda.getData().getMonth().getValue() == mes) {
                total += venda.calculaTotal();
            }
        }
        return total * comissao;
    }


    public double calculaComissao(int ano){
        double total = 0;
        for (Venda venda: vendas) {
            if (venda.getData().getYear() == ano) {
                total += venda.calculaTotal();
            }
        }
        return total * comissao;
    }



    void adicionaVenda(Venda venda){
        vendas.add(venda);
    }

    void removeVenda(Venda venda){
        vendas.remove(venda);
    }

    @Override
    public String getFuncao() {
        return "com.calcados.modelo.Vendedor";
    }


}
