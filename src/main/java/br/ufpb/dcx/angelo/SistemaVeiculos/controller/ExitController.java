package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitController extends JDialog implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //===================[ JANELA DO SAIR ]===============================
        JDialog dialogSair = new JDialog(this,"",true);
        dialogSair.setTitle("AVISO!");
        dialogSair.setSize(350,250);
        dialogSair.setLocationRelativeTo(null);
        dialogSair.setResizable(true);
        dialogSair.getContentPane().setBackground(Color.decode("#000622"));
        //===================[ ELEMENTOS DO SAIR ]===============================
        JLabel sairMesmo = new JLabel();
        JButton botaoSim, botaoNao;
        sairMesmo.setText("Você deseja mesmo sair?");
        botaoSim = new JButton("SIM");
        botaoNao = new JButton("VOLTAR");
        //===================[ESTILIZAÇÃO ELEMENTOS]===============================
        sairMesmo.setBounds(57,35,250,50);
        sairMesmo.setFont(new Font("Serif",Font.ROMAN_BASELINE,23));
        sairMesmo.setForeground(Color.white);

        botaoSim.setBounds(85,100,85,30);
        botaoSim.setFocusable(false);
        botaoSim.setBackground(Color.decode("#5271ff"));
        botaoSim.setForeground(Color.white);

        botaoNao.setBounds(175,100,85,30);
        botaoNao.setFocusable(false);
        botaoNao.setBackground(Color.decode("#5271ff"));
        botaoNao.setForeground(Color.white);
        //===================[AÇÃO DOS BOTÕES]===============================
        botaoSim.addActionListener(f-> {
            for (Window w : Window.getWindows()) {
                w.dispose();
            }
        });
        botaoNao.addActionListener(v->dispose());

        //===================[ADD ELEMENTOS]===============================
        dialogSair.add(sairMesmo);
        dialogSair.add(botaoSim);
        dialogSair.add(botaoNao);
        dialogSair.setLayout(null);
        dialogSair.setVisible(true);
    }
}
