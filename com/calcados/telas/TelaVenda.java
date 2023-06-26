package com.calcados.telas;

import com.calcados.modelo.Loja;
import com.calcados.modelo.Venda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaVenda {


    public static void criarConteudo(Container painel, Loja loja) {
        int altura = 120;
        int largura = 663;

        JLabel labelTitulo = new JLabel(
                "Vendas");
        labelTitulo.setBounds(20, 20, 750, 30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 20));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        JButton botaoNovaVenda = new JButton("Nova Venda");
        botaoNovaVenda.setBounds(650,20,130,40);
        botaoNovaVenda.setFont(
                new Font("Arial", Font.BOLD, 10));
        painel.add(botaoNovaVenda);

        botaoNovaVenda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaNovaVenda telaNovaVenda = new TelaNovaVenda(loja);
                telaNovaVenda.setVisible(true);

            }
        });

        String[] colunas = {"Código", "Data", "Total", "Vendedor"};
        String[][] dados = new String[loja.getVendas().size()][colunas.length];

        for (int i =0; i < loja.getVendas().size(); i++){
            Venda venda = loja.getVendas().get(i);
            dados[i][0] = String.valueOf(venda.getCodigo());
            dados[i][1] = String.valueOf(venda.getData());
            dados[i][2] = String.valueOf(venda.calculaTotal());
            dados[i][3] = String.valueOf(venda.getVendedor().getNomeCompleto());
            JButton detalhes = new JButton("Ver itens");
            detalhes.setFont(new Font("Arial", Font.BOLD, 9));
            detalhes.setBounds(largura,altura,100,25);
            painel.add(detalhes);
            altura+=26;

            detalhes.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TelaDetalhes telaDetalhes = new TelaDetalhes(venda, loja);
                    telaDetalhes.setVisible(true);

                }
            });

        }

        JTable tabela = new JTable(dados, colunas);
        tabela.setRowHeight(25);

        JScrollPane barraRolagem = new JScrollPane(tabela);

        barraRolagem.setBounds(63, 100, 600, 550); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela

    }
}
