package com.calcados.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    String nome;
    final private ArrayList<Venda> vendas = new ArrayList<>();
    final private ArrayList<Estoque> estoque = new ArrayList<>();
    final private ArrayList<Produto> produtoLoja = new ArrayList<>();
    final private ArrayList<Funcionario> funcionarios = new ArrayList<>();


    public Loja(String nome) {
        this.nome = nome;

        Produto p1 = new Produto("12345", "Santa lola", 150, "preto", "salto", "adulto" );
        adicionaProduto(p1);
        Produto p2 = new Produto("56792", "Grendene", 150, "preto", "salto", "adulto" );
        adicionaProduto(p2);

        Estoque p137 = new Estoque(p1, 8, 37);
        Estoque p135 = new Estoque(p1, 3, 35);
        Estoque p237= new Estoque(p2, 9, 37);
        Estoque p234= new Estoque(p2, 2, 34);
        Estoque p239= new Estoque(p2, 5, 39);

        adicionaItem(p137);
        adicionaItem(p135);
        adicionaItem(p237);
        adicionaItem(p234);
        adicionaItem(p239);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Estoque> getEstoque() {
        return estoque;
    }


    public List<Produto> getProduto() {
        return produtoLoja;
    }


    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    public void adicionaVenda(Venda venda){
        vendas.add(venda);
    }

    public void removeVenda(Venda venda){
        vendas.remove(venda);
    }

    public void adicionaItem(Estoque estoque){
        this.estoque.add(estoque);
    }

    public void removeItem(Estoque estoque){
        this.estoque.remove(estoque);
    }

    public void adicionaProduto(Produto produto){
        produtoLoja.add(produto);
    }

    public void removeProduto(Produto produto){
        produtoLoja.remove(produto);
    }

    public void adicionaFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }

    public double calculaFaturamento(LocalDate dataInicio, LocalDate dataLimite) {
        double saldoVendas = 0;
        for (Venda venda : vendas) {
            if (venda.getData().isAfter(dataInicio) && venda.getData().isBefore(dataLimite)) {
                saldoVendas += venda.calculaTotal();
            }
        }
        return saldoVendas;
    }

    public List<Estoque> retornaEstoqueProduto(Produto produto){
        ArrayList<Estoque> resultado = new ArrayList<>();
        for (Estoque itemEstoque: estoque) {
            if(itemEstoque.getProduto().equals(produto)){
                resultado.add(itemEstoque);
            }
        }
        return resultado;
    }

}
