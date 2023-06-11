package com.calcados.visao;

import com.calcados.modelo.Loja;
import com.calcados.modelo.Produto;

import javax.swing.*;
import java.awt.*;

public class TelaProdutos {

    public static void criarConteudo(Container painel, Loja loja){
        JLabel labelTitulo = new JLabel(
                "Produtos");
        labelTitulo.setBounds(20,20,750,30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 20));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        String[] colunas = {"Código", "Marca", "Preço", "Cor", "Descrição", "Faixa Etária"};
        String[][] dados = new String[loja.getProduto().size()][colunas.length];

        for (int i = 0; i < loja.getProduto().size(); i++) {
            Produto produto = loja.getProduto().get(i);
            dados[i][0] = produto.getCodigo();
            dados[i][1] = produto.getMarca();
            dados[i][2] = String.valueOf(produto.getPreco());
            dados[i][3] = produto.getCor();
            dados[i][4] = produto.getDescricao();
            dados[i][5] = produto.getFaixaEtaria();
        }

        JTable tabela = new JTable(dados, colunas);
        tabela.setBounds(20,200,800,400);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        painel.add(tabela);
        painel.add(barraRolagem);
    }
}
