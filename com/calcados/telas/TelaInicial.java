package com.calcados.telas;

import com.calcados.modelo.Loja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaInicial extends JFrame {
    private boolean ehHome = true;
    private Loja loja = new Loja("Gabriella");

        public TelaInicial(){
            super("Gerenciamento de calçados");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800,700);
            setLocationRelativeTo(null);

            setResizable(false);
            Container painel = getContentPane();

            painel.setLayout(null);
            painel.setBackground(Color.white);

            inserirMenu(painel);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("fechou");
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    System.out.println("executou");
                }
            });

        }

        private void limparContainer(Container painel){
            painel.removeAll();
            painel.revalidate();
            painel.repaint();
            if(!ehHome){
                botaoVoltar(painel);
            }

        }

        private void botaoVoltar(Container painel){
            ehHome = true;
            JButton botaoVoltar = new JButton("Voltar");
            botaoVoltar.setBounds(20,20,90,40);
            botaoVoltar.setFont(
                    new Font("Arial", Font.BOLD, 10));
            painel.add(botaoVoltar);
            botaoVoltar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    limparContainer(painel);
                    inserirMenu(painel);

                }
            });
        }

        private void inserirMenu(Container painel){
            JLabel labelTitulo = new JLabel(
                    "Menu");
            labelTitulo.setBounds(20,20,750,30);
            labelTitulo.setForeground(Color.DARK_GRAY);
            labelTitulo.setFont(
                    new Font("Arial", Font.BOLD, 20));
            labelTitulo.setHorizontalAlignment(JLabel.CENTER);
            painel.add(labelTitulo);

            JButton botaoVenda = new JButton("VENDA");
            botaoVenda.setBounds(170,130,180,120);
            botaoVenda.setFont(
                    new Font("Arial", Font.BOLD, 16));
            painel.add(botaoVenda);

            botaoVenda.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Quantidade de cliques: "
                            +e.getClickCount());
                    System.out.println("Local: "+e.getPoint());
                    ehHome = false;
                    limparContainer(painel);
                    TelaVenda.criarConteudo(painel, loja);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entrou no componente");
                }
            });


            JButton botaoProdutos = new JButton("PRODUTOS");
            botaoProdutos.setBounds(450,130,180,120);
            botaoProdutos.setFont(
                    new Font("Arial", Font.BOLD, 16));
            painel.add(botaoProdutos);

            botaoProdutos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Quantidade de cliques: "
                            +e.getClickCount());
                    System.out.println("Local: "+e.getPoint());
                    ehHome = false;
                    limparContainer(painel);
                    TelaProdutos.criarConteudo(painel, loja);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entrou no componente");
                }
            });

            JButton botaoFuncionarios = new JButton("FUNCIONÁRIOS");
            botaoFuncionarios.setBounds(170,350,180,120);
            botaoFuncionarios.setFont(
                    new Font("Arial", Font.BOLD, 16));
            painel.add(botaoFuncionarios);

            botaoFuncionarios.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ehHome = false;
                    limparContainer(painel);
                    TelaFuncionarios.criaTelaFuncionario(painel, loja);
                    System.out.println("Quantidade de cliques: "
                            +e.getClickCount());
                    System.out.println("Local: "+e.getPoint());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entrou no componente");
                }
            });

            JButton botaoCaixa = new JButton("CAIXA");
            botaoCaixa.setBounds(450,350,180,120);
            botaoCaixa.setFont(
                    new Font("Arial", Font.BOLD, 16));
            painel.add(botaoCaixa);

            botaoCaixa.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Quantidade de cliques: "
                            +e.getClickCount());
                    System.out.println("Local: "+e.getPoint());
                    ehHome = false;
                    limparContainer(painel);
                    TelaCaixa.criaTelaFuncionario(painel, loja);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Mouse entrou no componente");
                }
            });





        }


}
