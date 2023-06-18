package com.calcados.telas;

import com.calcados.enumerations.FaixaEtaria;
import com.calcados.modelo.Loja;
import com.calcados.modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class TelaCadastroProduto extends JFrame {
    Loja loja;
    Produto produto = new Produto();

    public TelaCadastroProduto(Loja loja) {
        super("Cadastrar novo produto");

        this.loja = loja;

        setSize(400, 550);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        inserirLabels(painel);
        inserirSelect(painel);
        inserirInput(painel);
    }

    private void inserirLabels(Container painel) {
        JLabel labelTitulo = new JLabel(
                "Cadastro de Produto");

        labelTitulo.setBounds(20, 20, 380, 30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 16));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        Font fonteLabels = new Font("Arial", Font.BOLD, 14);

        JLabel labelCodigo = new JLabel("Código");
        labelCodigo.setBounds(20, 70, 100, 30);
        labelCodigo.setFont(fonteLabels);
        painel.add(labelCodigo);

        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(20, 100, 100, 30);
        labelMarca.setFont(fonteLabels);
        painel.add(labelMarca);

        JLabel labelPreco = new JLabel("Preço");
        labelPreco.setBounds(20, 130, 100, 30);
        labelPreco.setFont(fonteLabels);
        painel.add(labelPreco);

        JLabel labelCor = new JLabel("Cor");
        labelCor.setBounds(20, 160, 100, 30);
        labelCor.setFont(fonteLabels);
        painel.add(labelCor);

        JLabel labelDescricao = new JLabel("Descrição");
        labelDescricao.setBounds(20, 190, 100, 30);
        labelDescricao.setFont(fonteLabels);
        painel.add(labelDescricao);

        JLabel labelFaixaEtaria = new JLabel("Faixa etária");
        labelFaixaEtaria.setBounds(20, 220, 100, 30);
        labelFaixaEtaria.setFont(fonteLabels);
        painel.add(labelFaixaEtaria);

    }

    private void inserirSelect(Container painel) {
        JComboBox<FaixaEtaria> campoFaixaEtaria = new JComboBox<>(FaixaEtaria.values());
        campoFaixaEtaria.setBounds(130, 220, 250, 30);
        painel.add(campoFaixaEtaria);
        campoFaixaEtaria.setSelectedIndex(2);

        produto.setFaixaEtaria(Objects.requireNonNull(campoFaixaEtaria.getSelectedItem()).toString());

        campoFaixaEtaria.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                FaixaEtaria faixaEtaria = (FaixaEtaria) campoFaixaEtaria.getSelectedItem();
                produto.setFaixaEtaria(faixaEtaria.toString());
            }
        });
    }

    public void inserirInput(Container painel) {
        JTextField campoCodigo = new JTextField();
        campoCodigo.setBounds(130, 70, 250, 30);
        painel.add(campoCodigo);

        JTextField campoMarca = new JTextField();
        campoMarca.setBounds(130, 100, 250, 30);
        painel.add(campoMarca);

        JTextField campoPreco = new JTextField();
        campoPreco.setBounds(130, 130, 250, 30);
        campoPreco.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // Ignora o caractere digitado
                }
            }
        });
        painel.add(campoPreco);

        JTextField campoCor = new JTextField();
        campoCor.setBounds(130, 160, 250, 30);
        painel.add(campoCor);

        JTextField campoDescricao = new JTextField();
        campoDescricao.setBounds(130, 190, 250, 30);
        painel.add(campoDescricao);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(280, 300, 100, 30);
        painel.add(botaoSalvar);
        botaoSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Captura os valores dos campos de entrada
                String codigo = campoCodigo.getText();
                String marca = campoMarca.getText();
                String precoTexto = campoPreco.getText();
                double preco = Double.parseDouble(precoTexto);
                String cor = campoCor.getText();
                String descricao = campoDescricao.getText();


                // Define os valores capturados no objeto produto
                produto.setCodigo(codigo);
                produto.setMarca(marca);
                produto.setPreco(preco);
                produto.setCor(cor);
                produto.setDescricao(descricao);

                loja.adicionaProduto(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado");

            }
        });

    }

}



