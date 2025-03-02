package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoCountController extends JDialog implements ActionListener {
   private SistemaVeiculo sistema;
   private JanelaInterna janela;

   public VeiculoCountController(SistemaVeiculo sistema, JanelaInterna janela){
       this.sistema = sistema;
       this.janela = janela;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       //===================[ JANELA DO ESTOQUE ]===============================
       JDialog dialogCount = new JDialog(this,"", true);
        dialogCount.setTitle("Quantidade de veículos em estoque");
        dialogCount.setSize(600,300);
        dialogCount.setLocationRelativeTo(null);
        dialogCount.setResizable(false);
        dialogCount.getContentPane().setBackground(Color.decode("#000622"));
        //===================[ ELEMENTOS DA JANELA ]============================
       JLabel tituloCount = new JLabel("VEÍCULOS EM ESTOQUE:");
       int quantVeiculos = sistema.quantidadeDeVeiculosEmEstoque();
       JLabel labelMarca = new JLabel("Veiculos: " + quantVeiculos);
       JButton ok = new JButton("OK");

        //===================[ ESTILIZAÇÕES DOS ELEMENTOS ]=============================

        tituloCount.setBounds(120, 50,400,50);
        tituloCount.setFont(new Font("Serif",Font.BOLD,30));
        tituloCount.setForeground(Color.WHITE);

        labelMarca.setBounds(250, 110,250,25);
        labelMarca.setFont(new Font("Serif",Font.ROMAN_BASELINE,25));
        labelMarca.setForeground(Color.WHITE);

        ok.setBounds(250,180,100,50);
        ok.setFont(new Font("Serif",Font.BOLD,20));
        ok.setBackground(Color.decode("#5271ff"));
        ok.setForeground(Color.WHITE);
        ok.setFocusable(false);
        ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ok.addActionListener(f-> dispose());

        //===================[ ADD A JANELA ]=============================
        dialogCount.add(ok);
        dialogCount.add(tituloCount);
        dialogCount.add(labelMarca);
        dialogCount.setLayout(null);
        //dialogCount.setUndecorated(true);
       dialogCount.setVisible(true);
    }
}
