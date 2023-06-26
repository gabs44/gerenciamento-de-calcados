package com.calcados.telas;

import com.calcados.modelo.Funcionario;
import com.calcados.modelo.Loja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFuncionarios {

    public static void criaTelaFuncionario(Container painel, Loja loja){
        int altura = 120;
        int largura = 710;

        JLabel labelTitulo = new JLabel("Funcionários");
        labelTitulo.setBounds(20,20,750,30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 20));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        String[] colunas = {"Nome", "Cargo"};
        String[][] dados = new String[loja.getFuncionarios().size()][colunas.length];

        for (int i = 0; i< loja.getFuncionarios().size(); i++){
            Funcionario funcionario = loja.getFuncionarios().get(i);
            dados[i][0] = funcionario.getNomeCompleto();
            dados[i][1] = funcionario.getFuncao();
            JButton verMais = new JButton("Ver mais");
            verMais.setFont(new Font("Arial", Font.BOLD, 9));
            verMais.setBounds(largura,altura,80,25);
            painel.add(verMais);
            altura+=26;

            verMais.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TelaSenha ts = new TelaSenha(loja, funcionario);
                    ts.setVisible(true);
                }
            });
        }

        JTable tabela = new JTable(dados, colunas);
        tabela.setRowHeight(25);
        JScrollPane barraRolagem = new JScrollPane(tabela);

        barraRolagem.setBounds(20, 100, 690, 550); // define o tamanho do JScrollPane
        painel.add(barraRolagem); // Adiciona o JScrollPane ao painel em vez da tabela


        JButton botaoNovoFuncionario= new JButton("Novo funcionário");
        botaoNovoFuncionario.setBounds(650,20,130,40);
        botaoNovoFuncionario.setFont(
                new Font("Arial", Font.BOLD, 10));
        painel.add(botaoNovoFuncionario);

        botaoNovoFuncionario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaFormularioFuncionario telaFormularioFuncionario= new TelaFormularioFuncionario(null, loja);
                telaFormularioFuncionario.setVisible(true);
            }
        });















    }





}
