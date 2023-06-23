package com.calcados.telas;

import com.calcados.modelo.Estoque;
import com.calcados.modelo.ItemVenda;
import com.calcados.modelo.Loja;
import com.calcados.modelo.Venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaDetalhes extends JFrame {
    Venda venda;
    Loja loja;

    public TelaDetalhes(Venda venda, Loja loja){
        super("Ver itens");

        this.venda = venda;
        this.loja = loja;

        setSize(600,600);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        criaTabelaDetalhes(painel);


    }

    void criaTabelaDetalhes(Container painel){

        ArrayList<ItemVenda> itensVenda = venda.getItens();
        String[] colunas = {"Produto", "Numeração", "Quantidade", "Preço Unitário", "Subtotal"};
        String[][] dados = new String[itensVenda.size()][colunas.length];

        for (int i =0; i < itensVenda.size(); i++){
            ItemVenda itemVenda = itensVenda.get(i);
            dados[i][0] = itemVenda.getItem().getProduto().getDescricao()+ " " +  itemVenda.getItem().getProduto().getMarca();
            dados[i][1] = String.valueOf(itemVenda.getItem().getNumeracao());
            dados[i][2] = String.valueOf(itemVenda.getQuantidade());
            dados[i][3] = String.valueOf(itemVenda.getPrecoUnitario());
            dados[i][4] = String.valueOf(itemVenda.getQuantidade() * itemVenda.getPrecoUnitario());
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        barraRolagem.setBounds(20, 20, 550, 450); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela


    }


}
