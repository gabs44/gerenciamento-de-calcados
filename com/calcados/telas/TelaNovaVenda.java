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

        setSize(700,550);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        insereSelectVenda(painel);
        criaTabelaItensVenda(painel);
        insereLabelVenda(painel);
    }

    private void insereLabelVenda(Container painel){

        Font fonteLabels = new Font("Arial", Font.BOLD, 14);

        JLabel labelVendedor = new JLabel("Vendedor:");
        labelVendedor.setBounds(40, 20, 100, 30);
        labelVendedor.setFont(fonteLabels);
        painel.add(labelVendedor);

        JLabel labelProduto = new JLabel("Produto:");
        labelProduto.setBounds(40, 90, 100, 30);
        labelProduto.setFont(fonteLabels);
        painel.add(labelProduto);

        JLabel labelNumeracao = new JLabel("Número:");
        labelNumeracao.setBounds(370, 90, 100, 30);
        labelNumeracao.setFont(fonteLabels);
        painel.add(labelNumeracao);

        JLabel labelQuantidade = new JLabel("Quantidade:");
        labelQuantidade.setBounds(450, 90, 380, 30);
        labelQuantidade.setFont(fonteLabels);
        painel.add(labelQuantidade);
    }
    private void insereSelectVenda(Container painel) {
        ArrayList<Funcionario> conjuntoVendedores = (ArrayList<Funcionario>) loja.getFuncionarios();
        String[] opcoes = new String[conjuntoVendedores.size()];

        for (int i = 0; i < conjuntoVendedores.size(); i++) {
            opcoes[i] = conjuntoVendedores.get(i).getNomeCompleto();
        }

        ArrayList<Produto> listaProdutos = (ArrayList<Produto>) loja.retornaProdutosEmEstoque();
        String[] opcoesProdutos = new String[listaProdutos.size()];

        for (int i = 0; i < listaProdutos.size(); i++) {
            opcoesProdutos[i] = listaProdutos.get(i).getCodigo() + " - " + listaProdutos.get(i).getDescricao() + " " + listaProdutos.get(i).getMarca()
                    + " " + listaProdutos.get(i).getCor() + " " + listaProdutos.get(i).getFaixaEtaria();
        }

//        ArrayList<Estoque> conjuntoEstoque = (ArrayList<Estoque>) loja.retornaEstoqueComNumeracaoDisponivel(listaProdutos.get(0)); //Precisa atualizar quando um produto for selecionado
//        String[] opcoesEstoque = new String[conjuntoEstoque.size()];
//
//        for (int i = 0; i < conjuntoEstoque.size(); i++) {
//            opcoesEstoque[i] = String.valueOf(conjuntoEstoque.get(i).getNumeracao());
//        }

        JComboBox<String> campoVendedor = new JComboBox<>(opcoes);
        campoVendedor.setBounds(40, 50, 250, 30);
        painel.add(campoVendedor);

        campoVendedor.setSelectedIndex(-1);

        JComboBox<String> campoProduto = new JComboBox<>(opcoesProdutos);
        campoProduto.setBounds(40, 120, 300, 30);
        painel.add(campoProduto);

        campoProduto.setSelectedIndex(-1);

        JComboBox<String> campoNumeracao = new JComboBox<>();
        campoNumeracao.setBounds(370, 120, 50, 30);
        painel.add(campoNumeracao);

        campoNumeracao.setSelectedIndex(-1);

        JTextField campoQuantidade = new JTextField();
        campoQuantidade.setBounds(450, 120, 50, 30);
        painel.add(campoQuantidade);


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

        campoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNumeracao.setModel(new DefaultComboBoxModel<>());
                if (campoProduto.getSelectedIndex() != -1) {

                    Produto produto = listaProdutos.get(campoProduto.getSelectedIndex());

                    // Atualize as opções de numeração com base no produto selecionado
                    ArrayList<Estoque> conjuntoEstoque = (ArrayList<Estoque>) loja.retornaEstoqueComNumeracaoDisponivel(produto);
                    String[] opcoesEstoque = new String[conjuntoEstoque.size()];

                    for (int i = 0; i < conjuntoEstoque.size(); i++) {
                        opcoesEstoque[i] = String.valueOf(conjuntoEstoque.get(i).getNumeracao());
                    }

                    // Atualize o modelo do campoNumeracao
                    DefaultComboBoxModel<String> numeracaoModel = new DefaultComboBoxModel<>(opcoesEstoque);
                    campoNumeracao.setModel(numeracaoModel);
                }
            }
        });



        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setBounds(550, 120, 100, 30);
        painel.add(botaoAdicionar);
        botaoAdicionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Produto produto = listaProdutos.get(campoProduto.getSelectedIndex());
                Estoque estoque = loja.procurarItemNoEstoque(produto, Integer.parseInt((String) campoNumeracao.getSelectedItem()));
                int quantidade = Integer.parseInt(campoQuantidade.getText());
                if(quantidade>estoque.getQuantidadeEmEstoque()){
                    JOptionPane.showMessageDialog(null, "Não há estoque suficiente");

                }
                else{
                    ItemVenda itemVenda = new ItemVenda(estoque, quantidade);
                    venda.adicionaItem(itemVenda);

                    Object[] row = new Object[modelo.getColumnCount()];
                    row[0] = itemVenda.getItem().getProduto().getDescricao()+ " " +  itemVenda.getItem().getProduto().getMarca();; //row = linha
                    row[1] = String.valueOf(itemVenda.getItem().getNumeracao());
                    row[2] = String.valueOf(itemVenda.getQuantidade());
                    row[3] = String.valueOf(itemVenda.getPrecoUnitario());
                    row[4] =  String.valueOf(itemVenda.getQuantidade() * itemVenda.getPrecoUnitario());
                    modelo.addRow(row);

                    campoProduto.setSelectedIndex(-1);
                    campoNumeracao.setSelectedIndex(-1);
                    campoQuantidade.setText("");
                }
            }
        });

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(300, 450, 100, 30);
        painel.add(botaoSalvar);

        botaoSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (ItemVenda itemVenda: venda.getItens()) {
                   Estoque estoque =  itemVenda.getItem();
                   estoque.setQuantidadeEmEstoque(estoque.getQuantidadeEmEstoque()- itemVenda.getQuantidade());

                }
                loja.adicionaVenda(venda);
                venda.getVendedor().adicionaVenda(venda);
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

        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(40, 180, 610, 250); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela

    }

}
