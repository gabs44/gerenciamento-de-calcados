package com.calcados.telas;

import com.calcados.modelo.Estoque;
import com.calcados.modelo.Loja;
import com.calcados.modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaEstoque extends JFrame {
    Produto produto;
    Loja loja;

    public TelaEstoque(Loja loja, Produto produto){
        super("Estoque");

        setSize(400,400);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);

        this.loja = loja;
        this.produto = produto;
        adicionarInformacoes(painel);
        criaTabelaEstoque(painel);


    }

    void adicionarInformacoes(Container painel){
        JLabel produtoEstoque= new JLabel(produto.getDescricao() + " " + produto.getMarca());
        produtoEstoque.setBounds(150,0, 150, 50);
        painel.add(produtoEstoque);

    }

    void criaTabelaEstoque(Container painel){
        ArrayList<Estoque> estoque = (ArrayList<Estoque>) loja.retornaEstoqueProduto(produto);
        System.out.println(estoque);
        String[] colunas = {"Numeração", "Quantidade"};
        String[][] dados = new String[estoque.size()][colunas.length];
        for (int i =0; i< estoque.size(); i++){
            Estoque itemEstoque = estoque.get(i);
            dados[i][0] = String.valueOf(itemEstoque.getNumeracao());
            dados[i][1] = String.valueOf(itemEstoque.getQuantidadeEmEstoque());
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        barraRolagem.setBounds(50, 50, 300, 300); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela

    }
}
