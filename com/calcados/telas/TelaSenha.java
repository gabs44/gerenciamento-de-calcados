package com.calcados.telas;

import com.calcados.modelo.Funcionario;
import com.calcados.modelo.Loja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class TelaSenha extends JFrame {
    Loja loja;
    Funcionario funcionario;
    final String senha = "12345";


    public TelaSenha( Loja loja, Funcionario funcionario){
        setSize(250,250);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);

        this.loja = loja;
        this.funcionario = funcionario;
        criaTelaSenha(painel);
    }

    public void criaTelaSenha(Container painel){
        JLabel labelSEnha = new JLabel("Informe a senha de acesso");
        labelSEnha.setBounds(25, 50, 200, 30);
        labelSEnha.setFont(Font.getFont("Arial"));
        painel.add(labelSEnha);
        JTextField campoSenha = new JTextField();
        campoSenha.setBounds(25, 100, 200, 30);
        painel.add(campoSenha);
        JButton botaoSalvar = new JButton("Avançar");
        botaoSalvar.setBounds(75, 150, 100, 30);
        painel.add(botaoSalvar);
        botaoSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String senhaInformada = campoSenha.getText();
                if(Objects.equals(senhaInformada, senha)){
                    TelaFormularioFuncionario telaFormularioFuncionario = new TelaFormularioFuncionario(funcionario, loja);
                    telaFormularioFuncionario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Senha incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                fecharJanelaSenha();
            }
        });


    }

    public void fecharJanelaSenha(){
        this.setVisible(false);
    }




}
