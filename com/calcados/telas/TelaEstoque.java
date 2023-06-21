package com.calcados.telas;

import com.calcados.modelo.Estoque;
import com.calcados.modelo.Loja;
import com.calcados.modelo.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class TelaEstoque extends JFrame {
    Produto produto;
    Loja loja;

    DefaultTableModel modelo;

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
        criaBotoes(painel);


    }

    void adicionarInformacoes(Container painel){
        JLabel produtoEstoque= new JLabel(produto.getDescricao() + " " + produto.getMarca());
        produtoEstoque.setBounds(150,0, 150, 50);
        painel.add(produtoEstoque);

    }

    void criaTabelaEstoque(Container painel){
        ArrayList<Estoque> estoque = (ArrayList<Estoque>) loja.retornaEstoqueProduto(produto);
        System.out.println(estoque);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Apenas a coluna 0 (Numeração) será não editável
                return column != 0;
            }
        };
        JTable tabela = new JTable(modelo);
        modelo.addColumn("Numeração");
        modelo.addColumn("Quantidade");

        for (Estoque itemEstoque : estoque) {
            Object[] row = new Object[modelo.getColumnCount()];
            row[0] = itemEstoque.getNumeracao(); //row = linha
            row[1] = itemEstoque.getQuantidadeEmEstoque();
            modelo.addRow(row);
        }

        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(50, 50, 300, 250); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela

    }

    void criaBotoes(Container painel) {

        JButton botaoSalvarAlteracoes = new JButton("Salvar");
        botaoSalvarAlteracoes.setBounds(150,325,90,30);
        botaoSalvarAlteracoes.setFont(new Font("Arial", Font.BOLD, 10));
        painel.add(botaoSalvarAlteracoes);

        botaoSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(modelo.getDataVector());
                for (Vector numeracaoQuant : modelo.getDataVector()) { //vetor dos valores da tabela
                    int numeracao = Integer.parseInt(numeracaoQuant.get(0).toString());
                    int quantidade = Integer.parseInt(numeracaoQuant.get(1).toString());
                    //procura um item do estoque baseado no produto selecionado e na numeração representada
                    Estoque resultado = loja.procurarItemNoEstoque(produto, numeracao);
                    //atualiza a quantidade de um item do estoque encontrado
                    resultado.setQuantidadeEmEstoque(quantidade);

                }
            }
        });

    }

}
