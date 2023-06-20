package com.calcados.telas;

import com.calcados.modelo.Loja;
import com.calcados.modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaProdutos {

    public static void criarConteudo(Container painel, Loja loja){
        int altura = 120;
        int largura = 710;

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
            dados[i][5] = String.valueOf(produto.getFaixaEtaria());
            JButton detalhes = new JButton("Detalhes");
            detalhes.setFont(new Font("Arial", Font.BOLD, 8));
            detalhes.setBounds(largura,altura,75,15);
            painel.add(detalhes);
            altura+=15;

            detalhes.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TelaEstoque te = new TelaEstoque(loja, produto);
                    te.setVisible(true);
                }
            });

        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        barraRolagem.setBounds(20, 100, 690, 550); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela

        JButton botaoNovoProduto= new JButton("Novo produto");
        botaoNovoProduto.setBounds(650,20,130,40);
        botaoNovoProduto.setFont(
                new Font("Arial", Font.BOLD, 10));
        painel.add(botaoNovoProduto);

        botaoNovoProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(loja);
                telaCadastroProduto.setVisible(true);
            }
        });
    }
}
