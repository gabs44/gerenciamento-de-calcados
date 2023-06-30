package com.calcados.modelo;


import com.calcados.enumerations.FaixaEtaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    String nome; //nome da loja
    final private ArrayList<Venda> vendas ; //conjunto de todas as vendas
    final private ArrayList<Estoque> estoque; //conjunto de todos os itens do estoque
    final private ArrayList<Produto> produtoLoja; //todos os produtos ofertados na loja
    final private ArrayList<Funcionario> funcionarios; //conjunto de todos os funcionários


    public Loja(String nome, ArrayList<Venda> vendas, ArrayList<Estoque> estoque, ArrayList<Produto> produtoLoja, ArrayList<Funcionario> funcionarios) {
        this.nome = nome;
        this.vendas = new ArrayList<>();
        this.estoque = new ArrayList<>();
        this.produtoLoja = new ArrayList<>();
        this.funcionarios = new ArrayList<>();

        Produto p1 = new Produto("12345", "Santa Lola", 150, "Preto", "Salto", FaixaEtaria.Adulto );
        adicionaProduto(p1);
        Produto p2 = new Produto("56792", "Grendene", 150, "Preto", "Salto", FaixaEtaria.Infantil );
        adicionaProduto(p2);
        procurarItemNoEstoque(p1, 35).setQuantidadeEmEstoque(5);
        procurarItemNoEstoque(p2, 30).setQuantidadeEmEstoque(3);

        Vendedor v1 = new Vendedor("Maria Clara", "14567829745", "8397654738","Patos", 1250, "uuu", 0.2);
        Funcionario v2 = new Vendedor("Maurício", "98645302712", "83993564829","São João", 1250, "vendedor", 0.2);
        adicionaFuncionario(v1);
        adicionaFuncionario(v2);

        Venda venda1 = new Venda(LocalDate.now(), v1);
        v1.adicionaVenda(venda1);
        adicionaVenda(venda1);

        ItemVenda itemVenda = new ItemVenda(getEstoque().get(2), 2);

        venda1.adicionaItem(itemVenda);

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

    public void adicionaProduto(Produto produto){ //Adiciona um produto na lista da loja e cria todas as entradas de estoque associadas a este produto
        produtoLoja.add(produto);
        int inicio = 33;
        int fim = 45;
        if(produto.getFaixaEtaria() == FaixaEtaria.Infantil){
            inicio = 10;
            fim = 33;
        }
        for (int i = inicio; i<=fim; i++){
            Estoque itemEstoque = new Estoque(produto, 0, i);
            adicionaItem(itemEstoque);
        }
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
            LocalDate dataVenda = venda.getData();
            if (dataVenda.isAfter(dataInicio.minusDays(1)) && dataVenda.isBefore(dataLimite.plusDays(1))) {
                saldoVendas += venda.calculaTotal();
            }
        }
        return saldoVendas;
    }

    public List<Estoque> retornaEstoqueProduto(Produto produto){ //Retorna todos os estoques de um produto, incluindo os que não estão disponíveis
        ArrayList<Estoque> resultado = new ArrayList<>();
        for (Estoque itemEstoque: estoque) {
            if(itemEstoque.getProduto().equals(produto)){
                resultado.add(itemEstoque);
            }
        }
        return resultado;
    }

    public List<Estoque> retornaEstoqueComNumeracaoDisponivel(Produto produto){ //produtos com numeração disponível para venda
        ArrayList<Estoque> resultado = new ArrayList<>();
        for (Estoque itemEstoque: retornaEstoqueProduto(produto)) {
            if(itemEstoque.getQuantidadeEmEstoque()>0){
                resultado.add(itemEstoque);
            }
        }
        return resultado;
    }

    public Estoque procurarItemNoEstoque(Produto produto, int numeracao){ //procura um item no estoque baseado em um produto e numeração específica
        for (Estoque itemEstoque: estoque) {
            if(itemEstoque.getProduto().equals(produto) && itemEstoque.getNumeracao() == numeracao){
                return itemEstoque;
            }
        }
        return null;
    }

    public List<Produto> retornaProdutosEmEstoque(){ //produtos que tem pelo menos 1 item no estoque
        ArrayList<Produto> resultado = new ArrayList<>();
        for (Produto produto: produtoLoja) {
            for (Estoque itemEstoque: retornaEstoqueProduto(produto)) {
                if(itemEstoque.getQuantidadeEmEstoque() > 0){
                    resultado.add(produto);
                    break;
                }
            }
        }
        return resultado;
    }


}
