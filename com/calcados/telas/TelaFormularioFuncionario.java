package com.calcados.telas;

import com.calcados.modelo.Funcionario;
import com.calcados.modelo.Loja;
import com.calcados.modelo.Vendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class TelaFormularioFuncionario extends JFrame {
    Funcionario funcionario;
    Loja loja;

    public TelaFormularioFuncionario(Funcionario funcionario, Loja loja){
        super("Dados completos");

        this.funcionario = funcionario;
        this.loja = loja;

        setSize(450,450);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        inserirLabels(painel);
        inserirInput(painel);
    }




    private boolean ehEdicao(){
        return this.funcionario != null;
    }

    private void salvarAlteracoes(){
        if(!ehEdicao()){
            funcionario = new Vendedor();
            loja.adicionaFuncionario(funcionario);
        }
    }

    private void inserirLabels(Container painel){
        String titulo = "Novo funcionário";
        Font fonteLabels = new Font("Arial", Font.BOLD, 14);

        if(ehEdicao()){
            titulo = "Editar";

            LocalDate hoje = LocalDate.now();

            JLabel labelComissao = new JLabel("Comissão Atual");
            labelComissao.setBounds(35, 250, 380, 30);
            labelComissao.setFont(fonteLabels);
            painel.add(labelComissao);

            Vendedor vendedor = (Vendedor) funcionario;
            JLabel labelValorComissao = new JLabel(String.valueOf(vendedor.calculaComissao(hoje.getMonthValue(), hoje.getYear())));
            labelValorComissao.setBounds(165, 250, 250, 30);
            painel.add(labelValorComissao);
        }
        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setBounds(20, 20, 380, 30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 16));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);



        JLabel labelNomeCompleto = new JLabel("Nome completo");
        labelNomeCompleto.setBounds(35, 70, 380, 30);
        labelNomeCompleto.setFont(fonteLabels);
        painel.add(labelNomeCompleto);

        JLabel labelCPF = new JLabel("CPF");
        labelCPF.setBounds(35, 100, 380, 30);
        labelCPF.setFont(fonteLabels);
        painel.add(labelCPF);

        JLabel labeltelefone = new JLabel("Telefone");
        labeltelefone.setBounds(35, 130, 380, 30);
        labeltelefone.setFont(fonteLabels);
        painel.add(labeltelefone);

        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(35, 160, 380, 30);
        labelEndereco.setFont(fonteLabels);
        painel.add(labelEndereco);

        JLabel labelSalario = new JLabel("Salário");
        labelSalario.setBounds(35, 190, 380, 30);
        labelSalario.setFont(fonteLabels);
        painel.add(labelSalario);

        JLabel labelFunção = new JLabel("Função");
        labelFunção.setBounds(35, 220, 380, 30);
        labelFunção.setFont(fonteLabels);
        painel.add(labelFunção);
    }

    private void inserirInput(Container painel){
        int posicaoX = 165;

        JTextField campoNomeCompleto = new JTextField();
        campoNomeCompleto.setBounds(posicaoX, 70, 250, 30);
        painel.add(campoNomeCompleto);

        JTextField campoCPF = new JTextField();
        campoCPF.setBounds(posicaoX, 100, 250, 30);
        painel.add(campoCPF);

        JTextField campoTelefone = new JTextField();
        campoTelefone.setBounds(posicaoX, 130, 250, 30);
        painel.add(campoTelefone);

        JTextField campoEndereço = new JTextField();
        campoEndereço.setBounds(posicaoX, 160, 250, 30);
        painel.add(campoEndereço);

        JTextField campoSalario = new JTextField();
        campoSalario.setBounds(posicaoX, 190, 250, 30);
        painel.add(campoSalario);

        JTextField campoFuncao = new JTextField();
        campoFuncao.setBounds(posicaoX, 220, 250, 30);
        painel.add(campoFuncao);

        JButton botaoRemover = new JButton("Remover");
        botaoRemover.setBounds(35, 300, 100, 30);
        botaoRemover.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loja.removeFuncionario(funcionario);
                fecharJanela();
            }
        });


        if (ehEdicao()){
            campoNomeCompleto.setText(funcionario.getNomeCompleto());
            campoFuncao.setText(funcionario.getFuncao());
            campoCPF.setText(funcionario.getCPF());
            campoEndereço.setText(funcionario.getEndereco());
            campoSalario.setText(String.valueOf(funcionario.getSalario()));
            campoTelefone.setText(funcionario.getTelefone());
            painel.add(botaoRemover);

        }

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(315, 300, 100, 30);
        painel.add(botaoSalvar);
        botaoSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nomeCompleto = campoNomeCompleto.getText();
                String CPF = campoCPF.getText();
                String telefone = campoTelefone.getText();
                String endereco = campoEndereço.getText();
                double salario = Double.parseDouble(campoSalario.getText());
                String funcao = campoFuncao.getText();

                salvarAlteracoes();
                funcionario.setNomeCompleto(nomeCompleto);
                funcionario.setCPF(CPF);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco);
                funcionario.setSalario(salario);
                funcionario.setFuncao(funcao);
                fecharJanela();


            }
        });



    }
    public void fecharJanela(){
        this.setVisible(false);
    }
}
