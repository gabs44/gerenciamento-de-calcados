package com.calcados.telas;

import com.calcados.modelo.Funcionario;

import javax.swing.*;
import java.awt.*;

public class TelaFormularioFuncionario extends JFrame {
    Funcionario funcionario;

    public TelaFormularioFuncionario(Funcionario funcionario){
        super("Dados completos");

        this.funcionario = funcionario;

        setSize(400,400);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);
        inserirLabels(painel);
    }




    private boolean ehEdicao(){
        return this.funcionario != null;
    }

    private void inserirLabels(Container painel){
        String titulo = "Novo funcionário";
        if(ehEdicao()){
            titulo = "Editar";
        }
        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setBounds(20, 20, 380, 30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 16));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        Font fonteLabels = new Font("Arial", Font.BOLD, 14);
    }
}
