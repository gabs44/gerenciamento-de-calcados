package com.calcados.telas;

import com.calcados.modelo.Loja;
import com.calcados.modelo.Venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaAdicionaProduto extends JFrame {

    Loja loja;
    Venda venda;

    DefaultTableModel modelo;

    public TelaAdicionaProduto(Loja loja, Venda venda, DefaultTableModel modelo){

        this.loja = loja;
        this.venda = venda;
        this.modelo = modelo;

        setSize(600,500);
        setLocationRelativeTo(null);
        Container painel = getContentPane();
        painel.setLayout(null);
        setResizable(false);


    }

}
