package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] options = {"SIM", "VOLTAR"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Você deseja mesmo sair?", "AVISO!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );

        if (escolha == 0) {
            for (Window w: Window.getWindows()) {
                w.dispose();
            }
        }
    }
}
