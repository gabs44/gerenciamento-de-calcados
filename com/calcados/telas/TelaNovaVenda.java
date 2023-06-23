package com.calcados.telas;

import com.calcados.enumerations.FaixaEtaria;
import com.calcados.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class TelaNovaVenda extends JFrame {
    Loja loja;

    Venda venda;

    DefaultTableModel modelo;

    public TelaNovaVenda(Loja loja){
        super("Nova venda");

        this.venda = new Venda(LocalDate.now(), null);
        this.loja = loja;

        setSize(600,500);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        insereSelectVendedor(painel);
        criaTabelaItensVenda(painel);
        adicionaBotaoNovoProduto(painel);
    }

    private void insereSelectVendedor(Container painel) {
        ArrayList<Funcionario> conjuntoVendedores = (ArrayList<Funcionario>) loja.getFuncionarios();
        String[] opcoes = new String[conjuntoVendedores.size()];

        for (int i = 0; i < conjuntoVendedores.size(); i++) {
            opcoes[i] = conjuntoVendedores.get(i).getNomeCompleto();
        }

        JComboBox<String> campoVendedor = new JComboBox<>(opcoes);
        campoVendedor.setBounds(40, 40, 250, 30);
        painel.add(campoVendedor);

        campoVendedor.setSelectedIndex(-1);

        campoVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeSelecionado = (String) campoVendedor.getSelectedItem();

                for (Funcionario vendedor : conjuntoVendedores) {
                    if (vendedor.getNomeCompleto().equals(nomeSelecionado)) {
                        venda.setVendedor((Vendedor) vendedor);
                        break;
                    }
                }
            }
        });
    }
    public void criaTabelaItensVenda(Container painel) {
        ArrayList<ItemVenda> itens = venda.getItens();

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabela = new JTable(modelo);
        modelo.addColumn("Produto");
        modelo.addColumn("Numeração");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Preço unitário");
        modelo.addColumn("Subtotal");

        for (ItemVenda itemVenda : itens) {
            Object[] row = new Object[modelo.getColumnCount()];
            row[0] = itemVenda.getItem().getProduto().getDescricao()+ " " +  itemVenda.getItem().getProduto().getMarca();; //row = linha
            row[1] = String.valueOf(itemVenda.getItem().getNumeracao());
            row[2] = String.valueOf(itemVenda.getQuantidade());
            row[3] = String.valueOf(itemVenda.getPrecoUnitario());
            row[4] =  String.valueOf(itemVenda.getQuantidade() * itemVenda.getPrecoUnitario());
            modelo.addRow(row);
        }


        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(40, 90, 520, 250); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela


    }

    private void adicionaBotaoNovoProduto(Container painel){
        JButton botaoNovoProduto = new JButton("Novo produto");
        botaoNovoProduto.setBounds(425, 40, 130, 30);
        botaoNovoProduto.setFont(new Font("Arial", Font.BOLD, 10));
        painel.add(botaoNovoProduto);
        botaoNovoProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaAdicionaProduto telaAdicionaProduto = new TelaAdicionaProduto(loja, venda, modelo);
                telaAdicionaProduto.setVisible(true);

            }
        });
    }
}
