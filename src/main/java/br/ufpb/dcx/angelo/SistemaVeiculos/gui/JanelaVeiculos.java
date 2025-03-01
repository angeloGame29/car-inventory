package br.ufpb.dcx.angelo.SistemaVeiculos.gui;

import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;

public class JanelaVeiculos extends JFrame {
    JLabel linha1, linha2;
    ImageIcon logoCarInventory = new ImageIcon("imgs/carLogoB.png");

    public JanelaVeiculos(){
        setTitle("Janela Principal");
        setSize(650, 570);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#000622"));

        JButton abrirInterna = new JButton("Entrar no inventario");
        abrirInterna.setBounds(120, 400, 200, 50);
        abrirInterna.setFont(new Font("Arial", Font.BOLD, 16));
        abrirInterna.setBackground(Color.decode("#5271ff"));
        abrirInterna.setForeground(Color.white);
        abrirInterna.setFocusable(false); //retira o foco

        JButton fecharPrincipal = new JButton("Fechar programa");
        fecharPrincipal.setBounds(330, 400, 200, 50);
        fecharPrincipal.setBackground(Color.decode("#5271ff"));
        fecharPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
        fecharPrincipal.setForeground(Color.white);
        fecharPrincipal.setFocusable(false);

        linha1 = new JLabel("SISTEMA CAR INVENTORY",JLabel.CENTER);
        linha1.setForeground(Color.decode("#ffffff"));
        linha1.setFont(new Font("Serif",Font.BOLD, 30));
        linha2 = new JLabel(logoCarInventory, JLabel.CENTER);
        add(linha1);
        add(linha2);
        setLayout(null);
        linha1.setBounds(100, -30, 450, 200);
        linha2.setBounds(100, 50, 450, 400);
        add(new JLabel());
        abrirInterna.addActionListener(e -> new JanelaInterna(this));
        fecharPrincipal.addActionListener(e -> dispose());
        abrirInterna.addActionListener(e -> dispose());
        add(abrirInterna);
        add(fecharPrincipal);
    }


    public static void main(String [] args){
        JFrame janelaveiculo = new JanelaVeiculos();
        janelaveiculo.setVisible(true);
        janelaveiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
