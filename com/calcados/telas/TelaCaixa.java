package com.calcados.telas;

import com.calcados.modelo.Loja;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCaixa {
    public static void criaTelaFuncionario(Container painel, Loja loja) {

        LocalDate hoje = LocalDate.now();
        LocalDate inicioMes = hoje.withDayOfMonth(1);

        JLabel labelTitulo = new JLabel("Balanço de Caixa");
        labelTitulo.setBounds(20,20,750,30);
        labelTitulo.setForeground(Color.DARK_GRAY);
        labelTitulo.setFont(
                new Font("Arial", Font.BOLD, 20));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelTitulo);

        String formatoData = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoData);

        MaskFormatter mascaraData = null;
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField campoDataInicio = new JFormattedTextField();
        campoDataInicio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        campoDataInicio.setBounds(130,120,100,30);
        if(mascaraData!=null){
            mascaraData.install(campoDataInicio);
        }


        String dia = String.valueOf(inicioMes.getDayOfMonth());
        if (inicioMes.getDayOfMonth() < 10){
            dia = "0"+inicioMes.getDayOfMonth();
        }
        String mes = String.valueOf(inicioMes.getMonthValue());
        if (inicioMes.getMonthValue() < 10){
            mes = "0"+inicioMes.getMonthValue();
        }
        System.out.println(dia + "/" + mes +"/" + inicioMes.getYear());
        campoDataInicio.setText(dia + "/" + mes +"/" + inicioMes.getYear());

        painel.add(campoDataInicio);

        JLabel labelDataInicio = new JLabel("Data Inicial");
        labelDataInicio.setBounds(130, 80, 100, 30);
        labelDataInicio.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(labelDataInicio);


        JFormattedTextField campoDataFinal = new JFormattedTextField();
        campoDataFinal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        campoDataFinal.setBounds(330,120,100,30);
        if(mascaraData!=null){
            mascaraData.install(campoDataFinal);
        }

        mes = String.valueOf(hoje.getMonthValue());
        if (hoje.getMonthValue() < 10){
            mes = "0"+hoje.getMonthValue();
        }
        campoDataFinal.setText(hoje.getDayOfMonth() + "/" + mes +"/" + hoje.getYear());

        painel.add(campoDataFinal);

        JLabel labelDataFinal = new JLabel("Data Final");
        labelDataFinal.setBounds(330, 80, 100, 30);
        labelDataFinal.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(labelDataFinal);

        JLabel resultado = new JLabel("");
        resultado.setBounds(350, 200, 300, 30);
        resultado.setFont(new Font("Arial", Font.BOLD, 28));
        painel.add(resultado);

        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(480, 120, 150, 30);
        painel.add(botaoPesquisar);
        botaoPesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double faturamento = loja.calculaFaturamento(LocalDate.parse(campoDataInicio.getText(), formatter), LocalDate.parse(campoDataFinal.getText(), formatter));
                resultado.setText(String.valueOf(faturamento));

            }
        });

    }
}
