package br.ufpb.dcx.angelo.SistemaVeiculos;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MeuProgramaJframeVeiculo {
    public static void main(String [] args){
        JFrame janelaveiculo = new JanelaVeiculos();
        janelaveiculo.setVisible(true);
        janelaveiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
